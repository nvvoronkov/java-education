package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.entity.CityEntity;

import java.sql.ResultSet;
import java.sql.SQLException;


public class HistoryMapper {
    public CityEntity mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return CityEntity.builder()
                .name(rs.getString("name"))
                .build();
    }
}
