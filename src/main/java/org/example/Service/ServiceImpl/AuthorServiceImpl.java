package org.example.Service.ServiceImpl;

import org.example.Entity.Author;
import org.example.Service.AuthorDMLService;
import org.example.Service.AuthorDQLService;
import org.example.repositories.AuthorRepository;
import org.example.repositories.AuthorRepositoryJPA;
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
