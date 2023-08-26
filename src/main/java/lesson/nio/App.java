package lesson.nio;

import lesson.nio.model.User;
import lesson.nio.repository.UserFileRepository;
import lesson.nio.service.UserFileService;

import java.io.File;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//TODO: https://leetcode.com/problems/container-with-most-water/
public class App {

    public static void main(String[] args) {
        File file = new File("users.csv");
        UserFileRepository userFileRepository = new UserFileRepository(file);
        UserFileService userFileService = new UserFileService(userFileRepository);

        List<User> all = userFileService.findAll();

        BigDecimal sumAll = all.stream()
                .filter(user -> user.getAge() > 30)
                .map(User::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalSum = all.stream()
                .map(user -> BigDecimal.valueOf(user.getId())
                        .add(BigDecimal.valueOf(user.getAge()))
                        .add(user.getSalary()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        boolean match = all.stream()
                .filter(user -> user.getId() % 2 == 0)
                .allMatch(user -> user.getSalary().compareTo(BigDecimal.valueOf(2000)) > 0);

        Set<String> listOfNames = all.stream()
                .skip(10)
                .map(User::getName)
                .collect(Collectors.toSet());

        BigDecimal max = all.stream()
                .map(User::getSalary)
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);
    }

}
