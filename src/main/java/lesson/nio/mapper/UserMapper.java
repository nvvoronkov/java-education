package lesson.nio.mapper;

import lesson.nio.model.User;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class UserMapper {

    public static final String USER_HEADERS = "id;name;age";

    public static User map(final String[] values) {
        return User.builder()
                .id(Long.valueOf(values[0]))
                .name(values[1])
                .age(Integer.parseInt(values[2]))
                .build();
    }

    public static String toUserLine(final User user) {
        return user.getId() + ";" + user.getName() + ";" + user.getAge() + System.lineSeparator();
    }

    public static String toUserLine(final List<User> userList) {
        var stringBuilder = new StringBuilder();
        stringBuilder.append(USER_HEADERS).append(System.lineSeparator());
        for (var user : userList) {
            stringBuilder.append(toUserLine(user));
        }
        return stringBuilder.toString();
    }
}
