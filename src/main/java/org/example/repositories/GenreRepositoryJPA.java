package org.example.repositories;

import org.example.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepositoryJPA extends JpaRepository<Genre, Integer> {
}
