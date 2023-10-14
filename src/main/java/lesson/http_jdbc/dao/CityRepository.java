package lesson.http_jdbc.dao;

import lesson.http_jdbc.model.entity.CityEntity;
import lesson.http_jdbc.util.DbConnectionUtils;
import lesson.nio.repository.CrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO:
public class CityRepository implements CrudRepository<CityEntity, Long> {
    private static final Logger logger = LoggerFactory.getLogger(CityRepository.class);

    @Override
    public Optional<CityEntity> findById(final Long id) {
        var sql = """
                SELECT *
                FROM city
                WHERE id = ?;
                """;

        try (var connection = DbConnectionUtils.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new CityEntity(resultSet.getLong("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<CityEntity> save(final CityEntity cityEntity) {
        if (isCityInStorage(cityEntity)) {
            logger.info("%s already in database", cityEntity.getName());
            throw new RuntimeException();
        } else {
            var sql = "insert into city (id, name) values (?, ?);";
            try (var connection = DbConnectionUtils.getConnection();
                 var preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, Math.toIntExact(cityEntity.getId()));
                preparedStatement.setString(2, cityEntity.getName());
                preparedStatement.executeUpdate();

                connection.commit();
                return Optional.of(cityEntity);
            } catch (SQLException e) {
//            try {
//                connection.rollback();
//            } catch (SQLException ex) {
//                logger.info(ex.getMessage());
//                throw new RuntimeException(ex);
//            }
                // как вызвать rollback в блоке catch
                logger.info(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(final Long id) {
        var sql = "DELETE FROM city WHERE id = ?";

        try (var connection = DbConnectionUtils.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CityEntity> findAll() {
        var sql = """
                SELECT *
                FROM city
                """;
        List<CityEntity> cities = new ArrayList<>();

        try (var connection = DbConnectionUtils.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cities.add(new CityEntity(resultSet.getLong("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
        return cities;
    }

    public boolean isCityInStorage(final CityEntity cityEntity) {
        return findById(cityEntity.getId()).equals(cityEntity);
    }
}
