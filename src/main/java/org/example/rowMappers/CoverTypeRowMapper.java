package org.example.rowMappers;

import org.example.Models.CoverType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoverTypeRowMapper implements RowMapper<CoverType> {

    @Override
    public CoverType mapRow(ResultSet rs, int rowNum) throws SQLException {
        CoverType coverType = new CoverType();

        coverType.setId(rs.getInt("id"));
        coverType.setCoverType(rs.getString("cover_type"));
        return coverType;
    }
}
