package org.example.booksapp.repositories;


import org.example.booksapp.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryJPA extends JpaRepository<Book,Integer> {


}
