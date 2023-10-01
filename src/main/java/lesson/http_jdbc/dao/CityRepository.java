package lesson.http_jdbc.dao;

import lesson.http_jdbc.model.entity.CityEntity;
import lesson.http_jdbc.util.DbConnectionUtils;
import lesson.nio.repository.CrudRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//TODO:
public class CityRepository implements CrudRepository<CityEntity, Long> {
    @Override
    public Optional<CityEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CityEntity> save(final CityEntity cityEntity) {
        var sql = "insert into city (name) values (?);";
        try (var connection = DbConnectionUtils.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cityEntity.getName());
            preparedStatement.executeUpdate();

            connection.commit();
            return Optional.of(cityEntity);
        } catch (SQLException e) {
            //TODO: Подключить нормальный логгер (sl4j)
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<CityEntity> findAll() {
        return null;
    }
}
