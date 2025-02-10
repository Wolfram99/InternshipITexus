package org.example.Service;

import com.fasterxml.jackson.databind.MappingIterator;
import org.example.Connectors.ConnectionForTheFile;
import org.example.Connectors.ConnectorBookCSV;
import org.example.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ReadCSV {
    private final ConnectionForTheFile connection;

    @Autowired
    public ReadCSV(ConnectionForTheFile connection) {
        super();
        this.connection = connection;
    }

    public Book findById(Integer id) {
        return	findAll().stream().filter(b -> Objects.equals(b.getId(), id)).findFirst().get();
    }

    public List<Book> findAll(){
        List<Book> books = new ArrayList<>();
        try (MappingIterator<Book> bookList = connection.getConnectionRead().readValues(new File(connection.getPathToFile()))){
            while (bookList.hasNext()) {
                books.add(bookList.next());
            }
        } catch (IOException e) {
            System.out.println("Файл не был найден!");
        }
        return books;
    }
}
