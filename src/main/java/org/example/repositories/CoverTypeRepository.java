package org.example.repositories;

import org.example.Models.CoverType;
import org.example.rowMappers.CoverTypeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CoverTypeRepository implements DBRepository<CoverType> {


    private final NamedParameterJdbcTemplate template;

    @Autowired
    public CoverTypeRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }



    @Override
    public List<CoverType> findAll() {
        return template.query("SELECT * FROM cover_type",new CoverTypeRowMapper());
    }

    @Override
    public Optional<CoverType> findById(Integer id) {
        return template.query("SELECT * FROM cover_type WHERE ID = :id",
                        new MapSqlParameterSource("id", id),
                        new CoverTypeRowMapper())
                .stream()
                .findAny();
    }

    @Override
    public void delete(Integer id) {
        template.update("DELETE FROM cover_type WHERE ID = :id", new MapSqlParameterSource("id", id));

    }

    @Override
    public void update(CoverType coverType) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", coverType.getId())
                .addValue("coverType", coverType.getCoverType());
        template.update("UPDATE cover_type SET cover_type = :coverType WHERE ID = :id", map);
    }

    @Override
    public void insert(CoverType coverType) {
        template.update("INSERT INTO cover_type (cover_type) VALUES (:coverType)", new MapSqlParameterSource("coverType", coverType.getCoverType()));
    }


}
