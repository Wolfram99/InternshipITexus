package org.example.rowMappers;

import org.example.Models.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();

        author.setId(rs.getInt("id"));
        author.setName(rs.getString("name"));
        author.setPatronymic(rs.getString("patronymic"));
        author.setSurname(rs.getString("surname"));
        author.setBrith_year(rs.getInt("brith_year"));

        return author;
    }
}
