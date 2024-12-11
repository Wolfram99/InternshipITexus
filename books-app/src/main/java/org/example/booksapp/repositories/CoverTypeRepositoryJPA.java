package org.example.booksapp.repositories;

import org.example.booksapp.Entity.CoverType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverTypeRepositoryJPA extends JpaRepository<CoverType, Integer> {
}
