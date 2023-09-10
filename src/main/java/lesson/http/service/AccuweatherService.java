package lesson.http.service;

import lesson.http.client.AccuweatherClient;
import lesson.http.model.LocationsRoot;
import lesson.http.model.TopCityCount;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Scanner;

@RequiredArgsConstructor
public class AccuweatherService {
    private final AccuweatherClient accuweatherClient;

    private static String getCityKey(final LocationsRoot[] cityLocations, final String englishName) {
        return Arrays.stream(cityLocations)
                .filter(locationsRoot -> locationsRoot.getEnglishName().equals(englishName))
                .map(LocationsRoot::getKey)
                .findFirst()
                .orElseThrow();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("How many cities do you want to see?");
            Arrays.stream(TopCityCount.values())
                    .forEach(topCityCount -> System.out.println(topCityCount.getValue()));
            int chosenValue = scanner.nextInt();

            var locationsRoots = accuweatherClient.getTopCities(TopCityCount.getTopCityCountByValue(chosenValue));

            System.out.println("Choose city");
            Arrays.stream(locationsRoots).forEach(System.out::println);
            String englishName = scanner.next();

            String cityKey = getCityKey(locationsRoots, englishName);

            var currentCondition = accuweatherClient.getCurrentCondition(cityKey);
            System.out.println(Arrays.toString(currentCondition));

            System.out.println("Do you want to repeat the request? (1 - yes, any other key - no)");
            choice = scanner.nextInt();
        } while (choice == 1);
    }

}
