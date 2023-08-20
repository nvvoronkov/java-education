package lesson.nio.repository;

import lesson.nio.mapper.UserMapper;
import lesson.nio.model.User;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO: BigDecimal разобраться, что это и зачем
//TODO: Расширить функционал для новой колонки salary
//TODO: nio vs io

//TODO: Посчитать среднюю зарплату по юзерам старше 30 лет
//TODO: Просуммировать колонки id, age, salary и посчитать общуюю сумму этих колонок -> BigDecimal
//TODO: Все Юзеры стоящие на четных id имеют зарплату больше 2000.0 -> true/false
//TODO: Получить уникальных список имен для всех юзеров начиная с позиции 10
//TODO: Найти максимальную зарплату по всем юзерам

//TODO: https://leetcode.com/problems/container-with-most-water/
@RequiredArgsConstructor
public class UserFileRepository implements CrudRepository<User, Long> {
    private final File file;

    @Override
    public Optional<User> findById(final Long id) {
        return findAll().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<User> save(final User user) {
        List<User> users = findAll();
        if (users.contains(user)) {
            users.set(users.indexOf(user), user);
            updateUsers(users);
        } else {
            addUserToFile(user);
        }
        return Optional.of(user);
    }

    @Override
    public void delete(final Long id) {
        List<User> users = findAll();
        users.removeIf(user -> user.getId().equals(id));
        updateUsers(users);
    }

    @Override
    public List<User> findAll() {
        try (Stream<String> fileLines = Files.lines(Paths.get(file.toURI()))) {
            return fileLines
                    .skip(1)
                    .map(line -> UserMapper.map(line.split(";")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void updateUsers(List<User> users) {
        try {
            var userLine = UserMapper.toUserLine(users);
            Files.writeString(Paths.get(file.toURI()), userLine, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUserToFile(final User user) {
        try {
            var userLine = UserMapper.toUserLine(user);
            Files.writeString(Paths.get(file.toURI()), userLine, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
