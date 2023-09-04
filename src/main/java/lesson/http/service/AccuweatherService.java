package lesson.http.service;

import lesson.http.client.AccuweatherClient;
import lesson.http.model.CurrentConditionResponse;
import lesson.http.model.LocationsRoot;
import lesson.http.model.TopCityCount;
import lesson.http.storage.AccuweatherStorage;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

//TODO: Прикрутить локальный кэш чтобы не делать кучу раз одинаковые звпросы для
//TODO получения getTopCities
@RequiredArgsConstructor
public class AccuweatherService {
    private final AccuweatherClient accuweatherClient;
    private final AccuweatherStorage accuweatherStorage;


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
        int choice;
        do {
            System.out.println("How many cities do you want to see?");
            Arrays.stream(TopCityCount.values())
                    .forEach(topCityCount -> System.out.println(topCityCount.getValue()));
            if (accuweatherStorage.getCache().isEmpty()) {
                //TODO Рефактор кода в виде функциональной цепочки optional
                Optional.of(scanner.nextInt())
                        .map(chosen -> accuweatherClient.getTopCities(TopCityCount.getTopCityCountByValue(chosen)))
                        .map(locationsRoots -> {
                            System.out.println("Choose city");
                            return getResponses(locationsRoots, scanner);
                        });
            } else {
                System.out.println("You use cache\nChoose city");
                LocationsRoot[] locationsRoots = accuweatherStorage.load();
                getResponses(locationsRoots, scanner);
            }
            System.out.println("Do you want to repeat the request? (1-yes, 2-no)");
            choice = scanner.nextInt();

        } while (choice < 2);
    }

    private CurrentConditionResponse[] getResponses(LocationsRoot[] locationsRoots, Scanner scanner) {
        Arrays.stream(locationsRoots).forEach(System.out::println);
        String englishName = scanner.next();
        CurrentConditionResponse[] currentCondition = accuweatherClient.getCurrentCondition(
                getCityKey(locationsRoots, englishName));
        System.out.println(Arrays.toString(currentCondition));
        return currentCondition;
    }
}
