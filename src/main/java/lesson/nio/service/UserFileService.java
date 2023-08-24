package lesson.nio.service;

import lesson.nio.repository.UserFileRepository;
import lesson.nio.exception.UserNotFoundException;
import lesson.nio.model.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserFileService {
    public static final String USER_NOT_FOUND_MESSAGE = "User with id: %d not found";
    private final UserFileRepository userFileRepository;

    public User findById(final Long id) {
        return userFileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MESSAGE.formatted(id)));
    }

    public User save(final User user) {
        return userFileRepository.save(user)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MESSAGE.formatted(user.getId())));
    }

    public void delete(final Long id) {
        userFileRepository.delete(id);
    }

    public List<User> findAll() {
        return  userFileRepository.findAll();
    }
}
