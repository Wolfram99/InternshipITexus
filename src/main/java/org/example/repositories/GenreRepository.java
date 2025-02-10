package org.example.repositories;


import org.example.Entity.Genre;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
        session.remove(session.find(Genre.class, id));

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



    //TODO: Criteria API
    @Override
    public List<Genre> findAll() {
        Session session = sessionFactory.getCurrentSession();
        var cb = session.getCriteriaBuilder();
        var criteria = cb.createQuery(Genre.class);
        var genre = criteria.from(Genre.class);
        criteria.select(genre);

        return session.createQuery(criteria).getResultList();
    }

    @Override
    public Genre findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Genre.class, id);
    }






}
