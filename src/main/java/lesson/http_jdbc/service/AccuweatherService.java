package lesson.http_jdbc.service;

import lesson.http_jdbc.client.AccuweatherClient;
import lesson.http_jdbc.dao.CityRepository;
import lesson.http_jdbc.dao.CurrentConditionRepository;
import lesson.http_jdbc.mapper.CityMapper;
import lesson.http_jdbc.mapper.CurrentConditionResponseMapper;
import lesson.http_jdbc.model.dto.LocationsRoot;
import lesson.http_jdbc.model.entity.CityEntity;
import lesson.http_jdbc.model.enums.TopCityCount;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class AccuweatherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccuweatherService.class);

    private final AccuweatherClient accuweatherClient;
    private final CityRepository cityRepository;
    private final CurrentConditionRepository currentConditionRepository;
    private final CityMapper cityMapper;
    private final CurrentConditionResponseMapper conditionMapper;

    public void run() {
        TopCityCount chosenValue = Arrays.stream(TopCityCount.values())
            .findAny()
            .orElseThrow();

        LocationsRoot[] topCities = accuweatherClient.getTopCities(chosenValue);

        List<CityEntity> cityEntities = Arrays.stream(topCities)
            .map(cityMapper::toEntity)
            .filter(cityEntity -> cityRepository.findById(cityEntity.getId()).isEmpty())
            .toList();
        cityEntities.forEach(cityRepository::save);

        String cityKey = Arrays.stream(topCities)
            .map(LocationsRoot::getKey)
            .findAny()
            .orElseThrow();

        var currentCondition = Arrays.stream(accuweatherClient.getCurrentCondition(cityKey))
            .map(response -> conditionMapper.toEntity(response, Long.valueOf(cityKey)))
            .toList();
        currentCondition.forEach(currentConditionRepository::save);

        LOGGER.info("OVER!");
    }
}
