package org.example.booksapp.repositories;

import org.example.booksapp.entities.CoverType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CoverTypeRepository implements DBRepository<CoverType> {


    private final SessionFactory sessionFactory;

    @Autowired
    public CoverTypeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CoverType> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT ct FROM CoverType ct", CoverType.class).getResultList();
    }

    @Override
    public CoverType findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(CoverType.class, id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.find(CoverType.class, id));
    }

    @Override
    @Transactional
    public void update(CoverType coverType) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(coverType);
    }

    @Override
    @Transactional
    public void insert(CoverType coverType) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(coverType);
    }


}
