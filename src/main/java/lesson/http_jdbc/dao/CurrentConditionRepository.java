package lesson.http_jdbc.dao;

import lesson.http_jdbc.model.entity.CurrentConditionEntity;
import lesson.http_jdbc.util.DbConnectionUtils;
import lesson.nio.repository.CrudRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CurrentConditionRepository implements CrudRepository<CurrentConditionEntity, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentConditionRepository.class);

    private static CurrentConditionEntity mapToCurrentConditionEntity(ResultSet resultSet) throws SQLException {
        return new CurrentConditionEntity(resultSet.getLong("id"),
            resultSet.getDouble("temp"),
            resultSet.getLong("city_id"));
    }

    @Override
    public Optional<CurrentConditionEntity> findById(final Long id) {
        var sql = "SELECT * FROM current_condition_history WHERE id = ?";

        Connection connection = DbConnectionUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapToCurrentConditionEntity(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<CurrentConditionEntity> save(final CurrentConditionEntity currentConditionEntity) {
        if (currentConditionEntity.getId() == null) {
            return insert(currentConditionEntity);
        }
        return update(currentConditionEntity);
    }

    private Optional<CurrentConditionEntity> update(final CurrentConditionEntity currentConditionEntity) {
        var sql = "UPDATE current_condition_history SET temp = ? WHERE id = ?";

        Connection connection = DbConnectionUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDouble(1, currentConditionEntity.getTemp());
            preparedStatement.setLong(2, currentConditionEntity.getId());
            preparedStatement.executeUpdate();

            connection.commit();
            return Optional.of(currentConditionEntity);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @NotNull
    private Optional<CurrentConditionEntity> insert(final CurrentConditionEntity currentConditionEntity) {
        var sql = "INSERT INTO current_condition_history (id, temp, city_id) VALUES (?, ?, ?)";
        Connection connection = DbConnectionUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, currentConditionEntity.getId());
            preparedStatement.setDouble(2, currentConditionEntity.getTemp());
            preparedStatement.setLong(3, currentConditionEntity.getCityId());
            preparedStatement.executeUpdate();

            if (currentConditionEntity.getId() == 0) {
                currentConditionEntity.setId(getGeneratedKeys(preparedStatement));
            }

            connection.commit();
            return Optional.of(currentConditionEntity);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(final Long id) {
        var sql = "DELETE FROM current_condition_history WHERE id = ?";
        Connection connection = DbConnectionUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CurrentConditionEntity> findAll() {
        var sql = "SELECT * FROM current_condition_history";
        List<CurrentConditionEntity> currentConditions = new ArrayList<>();
        Connection connection = DbConnectionUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                currentConditions.add(mapToCurrentConditionEntity(resultSet));
            }

        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
            throw new RuntimeException(e);
        }
        return currentConditions;
    }
}
