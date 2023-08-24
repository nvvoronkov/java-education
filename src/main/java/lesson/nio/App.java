package lesson.nio;

import lesson.nio.model.User;
import lesson.nio.repository.UserFileRepository;
import lesson.nio.service.UserFileService;
import lombok.SneakyThrows;

import java.io.File;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
//TODO: BigDecimal разобраться, что это и зачем
//TODO: Расширить функционал для новой колонки salary
//TODO: nio vs io

//TODO: Посчитать среднюю зарплату по юзерам старше 30 лет
//TODO: Просуммировать колонки id, age, salary и посчитать общуюю сумму этих колонок -> BigDecimal
//TODO: Все Юзеры стоящие на четных id имеют зарплату больше 2000.0 -> true/false
//TODO: Получить уникальных список имен для всех юзеров начиная с позиции 10
//TODO: Найти максимальную зарплату по всем юзерам

//TODO: https://leetcode.com/problems/container-with-most-water/
public class App {
    private static final Random random = new Random();

    //File, Files, Path, Paths
    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("users.csv");
        UserFileRepository userFileRepository = new UserFileRepository(file);
        UserFileService userFileService = new UserFileService(userFileRepository);

        List<User> listUsersOlderThan30 = userFileService.findAll().stream()
                .filter(user -> user.getAge() > 30)
                .toList();

        long sum = userFileService.findAll().stream()
                .map(user -> user.getId())
                .mapToLong(Long::longValue)
                .sum();

        int sum1 = userFileService.findAll().stream()
                .map(user -> user.getAge())
                .mapToInt(Integer::intValue)
                .sum();

        BigDecimal sum2 = userFileService.findAll().stream()
                .map(user -> user.getSalary())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal allSum = new BigDecimal("0");
        BigDecimal targetSalary = new BigDecimal("2000.0");
        BigDecimal bigDecimal = allSum.add(BigDecimal.valueOf(sum))
                                      .add(BigDecimal.valueOf(sum1)
                                      .add(sum2));
        System.out.println(bigDecimal);

        boolean match = userFileService.findAll().stream()
                .filter(user -> user.getId() % 2 == 0)
                .allMatch(user -> user.getSalary().compareTo(targetSalary) == 1);
        System.out.println(match);

        List<String> listOfNames = userFileService.findAll().stream()
                .filter(user -> user.getId() >= 10)
                .map(User::getName)
                .toList();
        System.out.println(listOfNames);

        Optional<BigDecimal> max = userFileService.findAll().stream()
                .map(User::getSalary)
                .max(Comparator.naturalOrder());
        System.out.println(max);
    }


//    public static void findAllId(List<Long> id) {
//        int sum = 0;
//        for (Long idUser : id) {
//            sum += idUser;
//        }
//    }
}
