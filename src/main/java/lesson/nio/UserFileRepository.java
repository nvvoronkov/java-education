package lesson.nio;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.List;
import java.util.Optional;

//TODO implement
@RequiredArgsConstructor
public class UserFileRepository implements CrudRepository<User, Long> {
    private final File file;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
