package org.example.booksapp.service.serviceimpl;

import org.example.booksapp.entities.Genre;
import org.example.booksapp.service.GenreDMLService;
import org.example.booksapp.service.GenreDQLService;
import org.example.booksapp.repositories.GenreRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GenreServiceImpl implements GenreDQLService, GenreDMLService {

    private final GenreRepositoryJPA repository;

    @Autowired
    public GenreServiceImpl(GenreRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void insert(Genre genre) {
        repository.save(genre);
    }

    @Override
    @Transactional
    public void update(Genre genre) {
        repository.save(genre);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Genre findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Genre> findAll() {
        return repository.findAll();
    }
}
