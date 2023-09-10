package lesson.http.dao;

import lesson.http.model.entity.CurrentConditionEntity;
import lesson.nio.model.User;
import lesson.nio.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class CurrentConditionRepository implements CrudRepository<CurrentConditionEntity, Long> {

    @Override
    public Optional<CurrentConditionEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> save(CurrentConditionEntity currentConditionEntity) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<CurrentConditionEntity> findAll() {
        return null;
    }
}
