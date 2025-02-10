package org.example.Service.ServiceImpl;

import org.example.Models.Genre;
import org.example.Service.GenreDMLService;
import org.example.Service.GenreDQLService;
import org.example.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreDQLService, GenreDMLService {

    private final GenreRepository repository;

    @Autowired
    public GenreServiceImpl(GenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Genre genre) {
        repository.insert(genre);
    }

    @Override
    public void update(Genre genre) {
        repository.update(genre);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
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
