package lesson.nio.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, K> {
    Optional<T> findById(K id);

    //update
    Optional<T> save(T t);

    void delete(K id);

    List<T> findAll();

}
