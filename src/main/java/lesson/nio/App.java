package lesson.nio;

import lesson.nio.model.User;
import lesson.nio.repository.UserFileRepository;
import lesson.nio.service.UserFileService;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Random;

public class App {
    private static final Random random = new Random();

    //File, Files, Path, Paths
    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("users.csv");
        UserFileRepository userFileRepository = new UserFileRepository(file);
        UserFileService userFileService = new UserFileService(userFileRepository);

        User user = userFileService.findById(15L);
        System.out.println(user);
        userFileService.save(User.builder()
                .id(15L)
                .name("Igor222")
                .age(22)
                .build());
    }

}
