package lesson.http_jdbc.util;

import lesson.http_jdbc.exeption.MyRuntimeException;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class ReadPropertiesUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadPropertiesUtils.class);

    public static String readProperty(final String key) {
        try (InputStream inputStream = ReadPropertiesUtils.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(key);

        } catch (IOException e) {
            LOGGER.info(e.getMessage());
            throw new MyRuntimeException(e.getMessage());
        }
    }
}

