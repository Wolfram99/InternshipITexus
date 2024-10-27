package org.example.repositories;

import org.example.Entity.Book;
import org.example.rowMappers.BookRowMapper;
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

public class BookRepository implements DBRepository<Book>{


    private final SessionFactory sessionFactory;

    @Autowired
    public BookRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Book.class,id));
    }

    @Override
    @Transactional
    public void update(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(book);
    }


    @Override
    @Transactional
    public void insert(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT b From Book b",Book.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class,id);
    }

}
