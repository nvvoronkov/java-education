package lesson.http.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@UtilityClass
public class ReadPropertiesUtils {
    private static final String PROPERTIES_FILE = "application.properties";

    public static String readProperty(final String key) {
        Properties properties = new Properties();
        Path path = Paths.get(PROPERTIES_FILE);
        try (InputStream inputStream = Files.newInputStream(path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}
