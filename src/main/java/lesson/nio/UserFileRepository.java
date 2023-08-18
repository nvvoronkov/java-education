package lesson.nio;

import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//TODO implement
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
        boolean userExists = users.stream()
                .anyMatch(existingUser -> existingUser.getId().equals(user.getId()));
        if (userExists) {
            users = users.stream()
                    .map(existingUser -> existingUser.getId().equals(user.getId()) ? user : existingUser)
                    .collect(Collectors.toList());
        } else {
            users.add(user);
        }
        writeToFile(users);
        return Optional.of(user);
    }

    @Override
    public void delete(final Long id) {
        List<User> users = findAll();
        users.removeIf(user -> user.getId().equals(id));
        writeToFile(users);
    }

    @Override
    public List<User> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                    .map(line -> UserMapper.map(line.split(";")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }

    public void writeToFile(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (User user : users) {
                writer.write(user.getId() + ";" + user.getName() + ";" + user.getAge());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }
}
