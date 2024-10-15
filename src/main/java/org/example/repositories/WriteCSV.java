package org.example.repositories;


import org.example.Connectors.ConnectionForTheFile;
import org.example.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
//Repository
@Component
public class WriteCSV {
    private final ConnectionForTheFile connection;

    @Autowired
    public WriteCSV(ConnectionForTheFile connection) {
        super();
        this.connection = connection;
    }

    public void create(List<Book> list ,Book newBook) {
        try {
            list.add(newBook)	;
            connection.getConnectionWrite().writeValues(new File(connection.getPathToFile())).writeAll(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(List<Book> list , Integer id) {
        try {
            connection.getConnectionWrite()
                    .writeValues(new File(connection.getPathToFile()))
                    .writeAll(list.stream()
                            .filter(b -> !Objects.equals(b.getId(), id))
                            .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(List<Book> list ,Book editBook) {
        try {
            connection.getConnectionWrite()
                    .writeValues(new File(connection.getPathToFile()))
                    .writeAll(list.stream()
                            .map(b -> Objects.equals(b.getId(), editBook.getId()) ? editBook : b)
                            .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
