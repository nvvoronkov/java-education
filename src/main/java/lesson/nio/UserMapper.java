package lesson.nio;

public class UserMapper {
    public static User map(String[] values) {
        return User.builder()
                .id(Long.valueOf(values[0]))
                .name(values[1])
                .age(Integer.parseInt(values[2]))
                .build();
    }
}
