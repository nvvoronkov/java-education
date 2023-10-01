package lesson.http.mapper;

import lesson.http.model.entity.HistoryEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class HistoryMapper implements RowMapper<HistoryEntity> {
    @Override
    public HistoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return HistoryEntity.builder()
                .name(rs.getString("name"))
                .build();
    }
}
