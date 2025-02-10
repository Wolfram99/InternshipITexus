package org.example.booksapp.service;

import java.util.List;

public interface DQLService<E> {

    E findById(Integer id);
    List<E> findAll();
}
