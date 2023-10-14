package lesson.http_jdbc.service;

import lesson.http_jdbc.client.AccuweatherClient;
import lesson.http_jdbc.dao.CityRepository;
import lesson.http_jdbc.dao.CurrentConditionRepository;
import lesson.http_jdbc.mapper.CityMapper;
import lesson.http_jdbc.mapper.CurrentConditionResponseMapper;
import lesson.http_jdbc.model.dto.CurrentConditionResponse;
import lesson.http_jdbc.model.dto.LocationsRoot;
import lesson.http_jdbc.model.dto.TopCityCount;
import lesson.http_jdbc.model.entity.CityEntity;
import lesson.http_jdbc.model.entity.CurrentConditionEntity;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class AccuweatherService {
    private final AccuweatherClient accuweatherClient;
    private final CityRepository cityRepository;
    private final CurrentConditionRepository currentConditionRepository;
    private final CityMapper cityMapper;
    private final CurrentConditionResponseMapper conditionMapper;
    private CityEntity cityEntity;


    private static String getCityKey(final LocationsRoot[] cityLocations, final String englishName) {
        return Arrays.stream(cityLocations)
                .filter(locationsRoot -> locationsRoot.getEnglishName().equals(englishName))
                .map(LocationsRoot::getKey)
                .findFirst()
                .orElseThrow();
    }

    //TODO:
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("How many cities do you want to see?");
            Arrays.stream(TopCityCount.values())
                    .forEach(topCityCount -> System.out.println(topCityCount.getValue()));
            int chosenValue = scanner.nextInt();
            var locationsRoots = accuweatherClient.getTopCities(TopCityCount.getTopCityCountByValue(chosenValue));

            List<LocationsRoot> listCities = Arrays.stream(locationsRoots).toList();
            Set<CityEntity> cityEntitySet = new HashSet<>();

            for (LocationsRoot locationRoot : listCities) {
                CityEntity entity = cityMapper.toEntity(locationRoot);
                System.out.println(entity);
                if (!(cityRepository.isCityInStorage(entity))) {
                    cityEntitySet.add(entity);
                }
            }
            cityEntitySet.forEach(cityRepository::save);

            System.out.println("Choose city");
            Arrays.stream(locationsRoots).forEach(System.out::println);
            String englishName = scanner.next();

            String cityKey = getCityKey(locationsRoots, englishName);

            var currentCondition = accuweatherClient.getCurrentCondition(cityKey);
            List<CurrentConditionResponse> conditionResponseList = Arrays.stream(currentCondition).toList();
            List<CurrentConditionEntity> currentConditionEntities = new ArrayList<>();
            for (CurrentConditionResponse condition : conditionResponseList) {
                currentConditionEntities.add(conditionMapper.toEntity(condition, Long.valueOf(cityKey)));
            }
            currentConditionEntities
                    .forEach(currentConditionRepository::save);

            System.out.println(Arrays.toString(currentCondition));
            System.out.println("Do you want to repeat the request? (1 - yes, any other key - no)");
            choice = scanner.nextInt();
        } while (choice == 1);
    }

}
