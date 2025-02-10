package org.example.booksapp.service;

public interface DMLService<E> {
    void insert(E e);
    void update(E e);
    void delete(Integer id);
}
