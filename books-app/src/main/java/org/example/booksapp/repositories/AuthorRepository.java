package org.example.booksapp.repositories;


import org.example.booksapp.entities.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

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
        Query<Author> query = session.createQuery("SELECT a FROM Author a", Author.class);
        query.setCacheable(true);

        return query.getResultList();
    }

    @Override
    public Author findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return  session.find(Author.class, id);
    }

}
