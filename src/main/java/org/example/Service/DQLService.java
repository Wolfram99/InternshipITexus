package org.example.Service;

import org.example.Models.Book;

import java.util.List;

public interface DQLService<E> {

    E findById(Integer id);
    List<E> findAll();
}
