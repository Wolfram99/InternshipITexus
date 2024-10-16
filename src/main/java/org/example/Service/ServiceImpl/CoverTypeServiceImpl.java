package org.example.Service.ServiceImpl;

import org.example.Models.CoverType;
import org.example.Service.CoverTypeDMLService;
import org.example.Service.CoverTypeDQLService;
import org.example.repositories.CoverTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverTypeServiceImpl implements CoverTypeDMLService, CoverTypeDQLService {

    private final CoverTypeRepository repository;

    @Autowired
    public CoverTypeServiceImpl(CoverTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(CoverType coverType) {
        repository.insert(coverType);
    }

    @Override
    public void update(CoverType coverType) {
        repository.update(coverType);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
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
