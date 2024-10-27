package org.example.repositories;


import org.example.Entity.Genre;
import org.example.rowMappers.GenreRowMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public class GenreRepository implements DBRepository<Genre> {

    private final SessionFactory sessionFactory;

    @Autowired
    public GenreRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Genre.class, id));

    }

    @Override
    @Transactional
    public void update(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(genre);

    }

    @Override
    @Transactional
    public void insert(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(genre);
    }

    @Override
    public List<Genre> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT g From Genre g", Genre.class).getResultList();
    }

    @Override
    public Genre findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Genre.class, id);
    }






}
