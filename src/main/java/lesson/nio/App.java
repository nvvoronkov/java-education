package lesson.nio;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class App {

    //File, Files, Path, Paths
    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("users.csv");
        Path csvPath = Paths.get(file.toURI());
        String lineSeparator = System.lineSeparator();
        User user = User.builder()
                .id(15L)
                .name("asdasd")
                .age(44)
                .build();

        String string = user.getId() + ";" + user.getName() + ";" + user.getAge();
        Files.writeString(csvPath, string + lineSeparator,
                StandardOpenOption.WRITE, StandardOpenOption.APPEND);

        try (Stream<String> lines = Files.lines(csvPath)) {
            List<User> userList = lines
                    .skip(1)
                    .map(line -> UserMapper.map(line.split(";")))
                    .toList();

            Long id = 4L;

            Optional<User> first = userList.stream()
                    .filter(user1 -> user1.getId().equals(id))
                    .findFirst();

            System.out.println(userList);
        }
    }
}
