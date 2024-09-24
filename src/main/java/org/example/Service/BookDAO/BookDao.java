package org.example.Service.BookDAO;

import org.example.Models.Book;
import org.example.Service.ReadCSV;
import org.example.Service.WriteCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDao implements BookDQLCommand, BookDMLCommand{
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
