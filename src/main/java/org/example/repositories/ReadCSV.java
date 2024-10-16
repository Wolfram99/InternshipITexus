package org.example.repositories;

import com.fasterxml.jackson.databind.MappingIterator;
import org.example.AppRunner;
import org.example.Connectors.ConnectionForTheFile;
import org.example.Loggers.Logger;
import org.example.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

//Repository CSV
@Component
public class ReadCSV {
    private final ConnectionForTheFile connection;
    private final MessageSource messageSource;
    private Logger logger;

    @Autowired
    public ReadCSV(ConnectionForTheFile connection, MessageSource messageSource, Logger logger) {
        this.connection = connection;
        this.messageSource = messageSource;
        this.logger = logger;
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
            logger.print(messageSource.getMessage("exceptionMessage.IOException", null, Locale.forLanguageTag(AppRunner.lang)));
        }
        return books;
    }
}
