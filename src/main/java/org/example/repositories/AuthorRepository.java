package org.example.repositories;

import org.example.Models.Author;
import org.example.rowMappers.AuthorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements DBRepository<Author>{

    private final NamedParameterJdbcTemplate template;

    @Autowired
    public AuthorRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void delete(Integer id) {
        template.update("DELETE FROM authors Where ID = :id", new MapSqlParameterSource("id", id));

    }

    @Override
    public void update(Author author) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", author.getId())
                .addValue("name", author.getName())
                .addValue("patronymic", author.getPatronymic())
                .addValue("surname", author.getSurname())
                .addValue("brithYear", author.getBrith_year());
        template.update("UPDATE authors SET name = :name, patronymic = :patronymic,surname = :surname,birth_year = :brithYear WHERE ID = :id", map);
    }

    @Override
    public void insert(Author author) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("name", author.getName())
                .addValue("patronymic", author.getPatronymic())
                .addValue("surname", author.getSurname())
                .addValue("brithYear", author.getBrith_year());
        template.update("INSERT INTO authors (name, patronymic, surname, birth_year) VALUES (:name, :patronymic, :surname, :brithYear) ", map);

    }

    @Override
    public List<Author> findAll() {
        return template.query("SELECT * FROM authors", new AuthorRowMapper());
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return template.query("SELECT * FROM authors WHERE ID = :id",
                        new MapSqlParameterSource("id",id),
                        new AuthorRowMapper())
                .stream()
                .findAny();
    }

}
