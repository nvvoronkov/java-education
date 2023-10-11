package lesson.http_jdbc.service;

import lesson.http_jdbc.client.AccuweatherClient;
import lesson.http_jdbc.dao.CityRepository;
import lesson.http_jdbc.dao.CurrentConditionRepository;
import lesson.http_jdbc.model.dto.LocationsRoot;
import lesson.http_jdbc.model.dto.TopCityCount;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Scanner;

@RequiredArgsConstructor
public class AccuweatherService {
    private final AccuweatherClient accuweatherClient;
    private CityRepository cityRepository;
    private CurrentConditionRepository currentConditionRepository;

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
            //cityRepository.save(locationsRoots);

            System.out.println("Choose city");
            Arrays.stream(locationsRoots).forEach(System.out::println);
            String englishName = scanner.next();

            String cityKey = getCityKey(locationsRoots, englishName);

            var currentCondition = accuweatherClient.getCurrentCondition(cityKey);
            System.out.println(Arrays.toString(currentCondition));
            //currentConditionRepository.save(currentCondition);
            System.out.println("Do you want to repeat the request? (1 - yes, any other key - no)");
            choice = scanner.nextInt();
        } while (choice == 1);
    }

}
