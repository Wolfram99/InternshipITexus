package org.example.booksapp.Service.ServiceImpl;

import org.example.booksapp.Entity.CoverType;
import org.example.booksapp.Service.CoverTypeDMLService;
import org.example.booksapp.Service.CoverTypeDQLService;
import org.example.booksapp.repositories.CoverTypeRepository;
import org.example.booksapp.repositories.CoverTypeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CoverTypeServiceImpl implements CoverTypeDMLService, CoverTypeDQLService {

    private final CoverTypeRepositoryJPA repository;

    @Autowired
    public CoverTypeServiceImpl(CoverTypeRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void insert(CoverType coverType) {
        repository.save(coverType);
    }

    @Override
    @Transactional
    public void update(CoverType coverType) {
        repository.save(coverType);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CoverType findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<CoverType> findAll() {
        return repository.findAll();
    }
}
