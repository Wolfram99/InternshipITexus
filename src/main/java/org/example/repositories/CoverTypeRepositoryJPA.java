package org.example.repositories;

import org.example.Entity.CoverType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverTypeRepositoryJPA extends JpaRepository<CoverType, Integer> {
}
