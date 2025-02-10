package org.example.booksapp.repositories;

import org.example.booksapp.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepositoryJPA extends JpaRepository<Genre, Integer> {
}
