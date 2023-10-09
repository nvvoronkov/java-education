package lesson.http_jdbc.util;

import lesson.http_jdbc.dao.CityRepository;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class ReadPropertiesUtils {
    private static final Logger logger = LoggerFactory.getLogger(CityRepository.class);

    public static String readProperty(final String key) {
        try (InputStream inputStream = ReadPropertiesUtils.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty(key);

        } catch (IOException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

