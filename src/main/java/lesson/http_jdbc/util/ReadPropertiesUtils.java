package lesson.http_jdbc.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class ReadPropertiesUtils {

    public static String readProperty(final String key) {
        try (InputStream inputStream = ReadPropertiesUtils.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(key);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

