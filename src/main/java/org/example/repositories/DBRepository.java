package org.example.repositories;

import org.example.Models.Genre;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;
import java.util.Optional;

public interface DBRepository<E> {

    public List<E> findAll();
    public Optional<E> findById(Integer id);
    public void delete(Integer id);
    public void update(E e);
    public void insert(E e);

}
