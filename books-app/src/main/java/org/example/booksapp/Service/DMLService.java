package org.example.booksapp.Service;

public interface DMLService<E> {
    void insert(E e);
    void update(E e);
    void delete(Integer id);
}
