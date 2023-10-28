package lesson.http_jdbc.dao;

import lesson.http_jdbc.exeption.MyRuntimeException;
import lesson.http_jdbc.mapper.CityMapper;
import lesson.http_jdbc.model.entity.CityEntity;
import lesson.http_jdbc.util.DbConnectionUtils;
import lesson.nio.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CityRepository implements CrudRepository<CityEntity, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityRepository.class);

    private final CityMapper cityMapper;

    @Override
    public Optional<CityEntity> findById(final Long id) {
        var sql = "SELECT * FROM city WHERE id = ?";
        var connection = DbConnectionUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(cityMapper.toEntity(resultSet));
            }
            resultSet.close();
            return Optional.empty();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
            throw new MyRuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<CityEntity> save(final CityEntity cityEntity) {
        var sql = "insert into city (id, name) values (?, ?);";
        var connection = DbConnectionUtils.getConnection();

        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, cityEntity.getId());
            preparedStatement.setString(2, cityEntity.getName());
            preparedStatement.executeUpdate();

            connection.commit();

            return Optional.of(cityEntity);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
            throw new MyRuntimeException(e.getMessage());
        }

    }

    @Override
    public void delete(final Long id) {
        var sql = "DELETE FROM city WHERE id = ?";
        var connection = DbConnectionUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
            throw new MyRuntimeException(e.getMessage());
        }
    }

    @Override
    public List<CityEntity> findAll() {
        var sql = "SELECT * FROM city";
        List<CityEntity> cities = new ArrayList<>();

        var connection = DbConnectionUtils.getConnection();
        try (var preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cities.add(cityMapper.toEntity(resultSet));
            }
            resultSet.close();
            return cities;
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
            throw new MyRuntimeException(e.getMessage());
        }
    }
}
