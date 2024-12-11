package org.example.booksapp.Service;

import java.util.List;

public interface DQLService<E> {

    E findById(Integer id);
    List<E> findAll();
}
