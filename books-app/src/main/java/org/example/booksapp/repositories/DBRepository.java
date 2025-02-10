package org.example.booksapp.repositories;

import java.util.List;
import java.util.Optional;

public interface DBRepository<E> {

    public List<E> findAll();
    public E findById(Integer id);
    public void delete(Integer id);
    public void update(E e);
    public void insert(E e);

}
