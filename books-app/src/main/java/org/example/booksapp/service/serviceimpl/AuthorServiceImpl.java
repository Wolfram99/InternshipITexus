package org.example.booksapp.service.serviceimpl;

import org.example.booksapp.entities.Author;
import org.example.booksapp.service.AuthorDMLService;
import org.example.booksapp.service.AuthorDQLService;
import org.example.booksapp.repositories.AuthorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorDQLService, AuthorDMLService {

    private final AuthorRepositoryJPA repository;

    @Autowired
    public AuthorServiceImpl(AuthorRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void insert(Author author) {
        repository.save(author);
    }

    @Override
    @Transactional
    public void update(Author author) {
        repository.save(author);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Author findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }
}
