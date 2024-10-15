package org.example.rowMappers;

import org.example.Models.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GenreRowMapper implements RowMapper<Genre> {


    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Genre genre = new Genre();

            genre.setId(rs.getInt("id"));
            genre.setGenre(rs.getString("genre"));

        return genre;
    }
}
