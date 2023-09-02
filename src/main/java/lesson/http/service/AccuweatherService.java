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

    //TODO: Цикл для запроса у пользователя города в котором он хочет посмотреть прогноз погоды
    //do while
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("How many cities do you want to see?");
            Arrays.stream(TopCityCount.values())
                    .forEach(topCityCount -> System.out.println(topCityCount.getValue()));
            int choose = scanner.nextInt();

            LocationsRoot[] cityLocations = accuweatherClient.getTopCities(TopCityCount.getTopCityCountByValue(choose));
            System.out.println(Arrays.toString(cityLocations));

        }
    }

}
