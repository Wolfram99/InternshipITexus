package org.example.Service.ServiceImpl;

import org.example.Models.Book;
import org.example.Service.BookDMLService;
import org.example.Service.BookDQLService;
import org.example.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookDMLService, BookDQLService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Book book) {
        repository.insert(book);
    }

    @Override
    public void update(Book book) {
        repository.update(book);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
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
