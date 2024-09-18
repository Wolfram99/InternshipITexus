package org.example.Connectors;



import jakarta.annotation.PostConstruct;
import org.example.Models.Book;
import org.example.Schems.BookSchemaCSV;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;


@Component
public class ConnectorBookCSV implements ConnectionForTheFile{

    @Value("${pathToFile}")
    private String pathToFile;
    private CsvMapper csvMapper;

    public String getPathToFile() {
        return pathToFile;
    }

    @PostConstruct
    private void initMethod() {
        System.out.println("ANNotations post ");
        csvMapper = new CsvMapper();
        csvMapper.addMixIn(Book.class, BookSchemaCSV.class);
    }

    public ObjectReader getConnectionRead() {
        return csvMapper.readerFor(Book.class).with(BookSchemaCSV.getBookSchemaCSV());
    }

    public ObjectWriter getConnectionWrite() {
        return csvMapper.writerFor(Book.class).with(BookSchemaCSV.getBookSchemaCSV());
    }
}















