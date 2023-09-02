package lesson.http.service;

import lesson.http.client.AccuweatherClient;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class AccuweatherService {
    private final AccuweatherClient accuweatherClient;

    //TODO: Цикл для запроса у пользователя города в котором он хочет посмотреть прогноз погоды
    //do while
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("choose city:\n1 - Moscow\n2 - London\n3 - New-York\n");
            int choose = scanner.nextInt();
            StringBuilder city = new StringBuilder();

            switch (choose) {
                case (1) -> city.append("Moscow");
                case (2) -> city.append("London");
                case (3) -> city.append("New-York");
            }
            System.out.println(accuweatherClient.getCurrentConditions(String.valueOf(city)));
            break;
        }
    }
}
