package org.example.repositories;

import org.example.Entity.Author;
import org.example.rowMappers.AuthorRowMapper;
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
public class AuthorRepository implements DBRepository<Author>{

    private final SessionFactory sessionFactory;

    public AuthorRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.find(Author.class, id));
    }

    @Override
    @Transactional
    public void update(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(author);
    }

    @Override
    @Transactional
    public void insert(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(author);
    }

    @Override
    public List<Author> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    @Override
    public Author findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return  session.find(Author.class, id);
    }

}
