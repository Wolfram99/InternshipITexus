package org.example.booksapp.BookDAO;

import org.example.booksapp.Entity.Book;
import org.example.booksapp.Service.BookDMLService;
import org.example.booksapp.Service.BookDQLService;
import org.example.booksapp.repositories.ReadCSV;
import org.example.booksapp.repositories.WriteCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//Service
@Component
public class BookDao implements BookDQLService, BookDMLService {
    private final ReadCSV readCSV;
    private final WriteCSV writeCSV;

    @Autowired
    public BookDao(ReadCSV readCSV, WriteCSV writeCSV) {
        this.readCSV = readCSV;
        this.writeCSV = writeCSV;
    }

    @Override
    public void insert(Book newBook) {
        writeCSV.create(readCSV.findAll(), newBook);
    }

    @Override
    public void update(Book editBook) {
        writeCSV.update(readCSV.findAll(), editBook);
    }

    @Override
    public void delete(Integer id) {
        writeCSV.delete(readCSV.findAll(), id);
    }

    @Override
    public Book findById(Integer id) {
        return readCSV.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return readCSV.findAll();
    }
}
