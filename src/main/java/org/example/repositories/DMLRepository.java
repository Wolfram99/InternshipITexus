package org.example.repositories;

import org.example.Models.Genre;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public interface DMLRepository<E> {

    public void delete(Integer id);
    public void update(E e);
    public void insert(E e);

}
