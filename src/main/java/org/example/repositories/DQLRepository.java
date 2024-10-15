package org.example.repositories;

import java.util.List;
import java.util.Optional;

public interface DQLRepository<E> {

    public List<E> findAll();
    public E findById(Integer id);
}
