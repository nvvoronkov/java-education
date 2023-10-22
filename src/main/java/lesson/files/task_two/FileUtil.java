package lesson.files.task_two;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {
    public static File openFile(final String path) throws FileNotFoundException {
        try {
            URI uri = URI.create(path);
            Path path1 = Paths.get(uri);
            return path1.toFile();
        } catch (Exception e) {
            throw new FileNotFoundException(e.getMessage());
        }

    }
}
