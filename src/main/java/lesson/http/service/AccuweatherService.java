package lesson.http.service;

import lesson.http.client.AccuweatherClient;
import lesson.http.model.LocationsRoot;
import lesson.http.model.TopCityCount;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

//TODO: Прикрутить локальный кэш чтобы не делать кучу раз одинаковые звпросы для
//TODO получения getTopCities
@RequiredArgsConstructor
public class AccuweatherService {
    private final AccuweatherClient accuweatherClient;

    private static String getCityKey(LocationsRoot[] cityLocations, String englishName) {
        return Arrays.stream(cityLocations)
                .filter(locationsRoot -> locationsRoot.getEnglishName().equals(englishName))
                .map(LocationsRoot::getKey)
                .findFirst()
                .orElseThrow();
    }

    //TODO: do while
    //TODO условие выхода
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("How many cities do you want to see?");
            Arrays.stream(TopCityCount.values())
                    .forEach(topCityCount -> System.out.println(topCityCount.getValue()));

            //TODO Рефактор кода в виде функциональной цепочки optional
            Optional.of(scanner.nextInt())
                    .map(chosen -> accuweatherClient.getTopCities(TopCityCount.getTopCityCountByValue(chosen)))
                    .map(locationsRoots -> {
                        System.out.println();
                        System.out.println();
                        return null;
                    });


//            System.out.println("Choose city");
//            Arrays.stream(cityLocations).forEach(System.out::println);
//            String englishName = scanner.next();
//
//            CurrentConditionResponse[] currentCondition = accuweatherClient.getCurrentCondition(
//                    getCityKey(cityLocations, englishName));
//            System.out.println(Arrays.toString(currentCondition));
        }
    }
}
