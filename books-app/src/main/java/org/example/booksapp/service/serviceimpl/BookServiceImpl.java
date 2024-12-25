package org.example.booksapp.service.serviceimpl;

import org.example.booksapp.entities.Book;
import org.example.booksapp.service.BookDMLService;
import org.example.booksapp.service.BookDQLService;
import org.example.booksapp.repositories.BookRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookDMLService, BookDQLService {

    private final BookRepositoryJPA repository;

    @Autowired
    public BookServiceImpl(BookRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void insert(Book book) {
        repository.save(book);
    }

    @Override
    @Transactional
    public void update(Book book) {
        repository.save(book);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Book findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }
}
