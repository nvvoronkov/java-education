package lesson.http_jdbc.dao;

import lesson.http_jdbc.model.entity.CurrentConditionEntity;
import lesson.http_jdbc.util.DbConnectionUtils;
import lesson.nio.repository.CrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO:
public class CurrentConditionRepository implements CrudRepository<CurrentConditionEntity, Long> {
    private static final Logger logger = LoggerFactory.getLogger(CityRepository.class);

    @Override
    public Optional<CurrentConditionEntity> findById(final Long id) {
        var sql = "SELECT * FROM current_condition_history WHERE id = ?";

        try (Connection connection = DbConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new CurrentConditionEntity(resultSet.getLong("id"),
                        resultSet.getDouble("temp"),
                        resultSet.getLong("city_id")));
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<CurrentConditionEntity> save(final CurrentConditionEntity currentConditionEntity) {
        var sql = "INSERT INTO current_condition_history (temp, city_id, created_on) VALUES (?, ?, ?) RETURNING id";

        try (Connection connection = DbConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, currentConditionEntity.getTemp());
            preparedStatement.setLong(2, currentConditionEntity.getCityId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                currentConditionEntity.setId(id);
                return Optional.of(currentConditionEntity);
            }

            connection.commit();
        } catch (SQLException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void delete(final Long id) {
        var sql = "DELETE FROM current_condition_history WHERE id = ?";

        try (Connection connection = DbConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CurrentConditionEntity> findAll() {
        var sql = "SELECT * FROM current_condition_history";
        List<CurrentConditionEntity> currentConditions = new ArrayList<>();

        try (Connection connection = DbConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                currentConditions.add(new CurrentConditionEntity(resultSet.getLong("id"),
                        resultSet.getDouble("temp"),
                        resultSet.getLong("city_id")));
            }

        } catch (SQLException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
        return currentConditions;
    }
}
