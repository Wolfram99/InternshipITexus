package org.example.rowMappers;

import org.example.Models.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(rs.getInt("id"));
        book.setName(rs.getString("name"));
        book.setShortDescription(rs.getString("short_description"));
        book.setAuthorId(rs.getInt("author_id"));
        book.setGenreId(rs.getInt("genre_id"));
        book.setPublication_year(rs.getInt("publication_year"));
        book.setVolume(rs.getInt("volume"));
        book.setCoverTypeId(rs.getInt("cover_type_id"));

        return book;
    }
}
