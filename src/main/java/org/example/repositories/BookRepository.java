package org.example.repositories;

import org.example.Models.Book;
import org.example.rowMappers.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository implements DBRepository<Book>{


    private final NamedParameterJdbcTemplate template;


    @Autowired
    public BookRepository(NamedParameterJdbcTemplate template) {
        super();
        this.template = template;
    }

    @Override
    public void delete(Integer id) {
        template.update("DELETE FROM Books WHERE ID = :id", new MapSqlParameterSource("id",id));
    }

    @Override
    public void update(Book book) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", book.getId())
                .addValue("name", book.getName())
                .addValue("shortDescription", book.getShortDescription())
                .addValue("authorId", book.getAuthorId())
                .addValue("genreId", book.getGenreId())
                .addValue("publicationYear", book.getPublication_year())
                .addValue("volume", book.getVolume())
                .addValue("coverTypeId", book.getCoverTypeId());
        template.update("UPDATE Books SET name = :name, short_description = :shortDescription, author_id = :authorId, genre_id = :genreId, publication_year = :publicationYear, volume = :volume, cover_type_id = :coverTypeId WHERE ID = :id",
                map);
    }


    @Override
    public void insert(Book book) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("name", book.getName())
                .addValue("shortDescription", book.getShortDescription())
                .addValue("authorId", book.getAuthorId())
                .addValue("genreId", book.getGenreId())
                .addValue("publicationYear", book.getPublication_year())
                .addValue("volume", book.getVolume())
                .addValue("coverTypeId", book.getCoverTypeId());
        template.update("INSERT INTO Books (name, short_description, author_id, genre_id, publication_year, volume, cover_type_id) VALUES (:name, :shortDescription, :authorId, :genreId, :publicationYear, :volume, :coverTypeId)",
                map);
    }

    @Override
    public List<Book> findAll() {
        return template.query("SELECT * FROM Books", new BookRowMapper());
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return template.query("SELECT * FROM Books WHERE ID = :id",
                        new MapSqlParameterSource("id",id),
                        new BookRowMapper())
                .stream()
                .findAny();
    }

}
