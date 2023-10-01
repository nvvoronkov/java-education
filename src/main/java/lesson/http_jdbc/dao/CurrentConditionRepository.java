package lesson.http_jdbc.dao;

import lesson.http_jdbc.model.entity.CurrentConditionEntity;
import lesson.nio.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//TODO:
public class CurrentConditionRepository implements CrudRepository<CurrentConditionEntity, Long> {

    @Override
    public Optional<CurrentConditionEntity> findById(final Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CurrentConditionEntity> save(final CurrentConditionEntity currentConditionEntity) {
        return Optional.empty();
    }

    @Override
    public void delete(final Long id) {

    }

    @Override
    public List<CurrentConditionEntity> findAll() {
        return null;
    }
}
