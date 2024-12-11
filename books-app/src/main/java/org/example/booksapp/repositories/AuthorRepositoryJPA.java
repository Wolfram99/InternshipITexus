package org.example.booksapp.repositories;

//import org.example.Entity.Author;
import org.example.booksapp.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepositoryJPA extends JpaRepository<Author, Integer> {
}
