package org.example.Service.ServiceImpl;

import org.example.Models.Author;
import org.example.Service.AuthorDMLService;
import org.example.Service.AuthorDQLService;
import org.example.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorDQLService, AuthorDMLService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Author author) {
        repository.insert(author);
    }

    @Override
    public void update(Author author) {
        repository.update(author);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
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
