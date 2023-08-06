package lesson_three.task_two;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    public static File openFile(String path) throws FileNotFoundException {
        try {
            URI uri = URI.create(path);
            Path path1 = Paths.get(uri);
            return path1.toFile();
        } catch (Exception e) {
            throw new FileNotFoundException(e.getMessage());
        }

    }
}
