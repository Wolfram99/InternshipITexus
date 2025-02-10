package org.example.Schems;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.example.Models.Book;

@JsonPropertyOrder({"id","name","author","short description"})
public abstract class BookSchemaCSV {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("author")
    private String author;
    @JsonProperty("short description")
    private String shortDescription;

    public static CsvSchema getBookSchemaCSV() {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper
                .schemaFor(BookSchemaCSV.class)
                .withHeader();
        csvMapper.addMixIn(Book.class, BookSchemaCSV.class);
        return csvSchema;
    }
}
