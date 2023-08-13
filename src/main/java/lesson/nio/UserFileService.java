package lesson.nio;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFileService {
    public static final String USER_NOT_FOUND_MESSAGE = "User with id: %d not found";
    private final UserFileRepository userFileRepository;

    //TODO
    public User findById(Long id) {
        return userFileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MESSAGE.formatted(id)));
    }
}
