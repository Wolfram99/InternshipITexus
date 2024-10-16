package org.example.repositories;


import org.example.Models.Genre;
import org.example.rowMappers.GenreRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class GenreRepository implements DBRepository<Genre> {

    private final NamedParameterJdbcTemplate template;

    @Autowired
    public GenreRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    @Override
    public void delete(Integer id) {
        SqlParameterSource map = new MapSqlParameterSource("id",id);
        template.update("DELETE FROM GENRES WHERE ID=:id", map);
    }

    @Override
    public void update(Genre genre) {
        SqlParameterSource map = new MapSqlParameterSource()
            .addValue("id",genre.getId())
            .addValue("genre",genre.getGenre());
        template.update("UPDATE Genres SET genre = :genre WHERE ID = :id", map);
    }

    @Override
    public void insert(Genre genre) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("genre",genre.getGenre());
        template.update("INSERT INTO Genres (genre) VALUES (:genre)", map);
    }

    @Override
    public List<Genre> findAll() {
        return template.query("SELECT * FROM GENRES", new GenreRowMapper());
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        SqlParameterSource map = new MapSqlParameterSource("id",id);
        return template.query("SELECT * FROM GENRES WHERE ID = :id", map, new GenreRowMapper()).stream().findAny();
    }






}
