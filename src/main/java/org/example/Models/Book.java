package org.example.Models;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

    private Integer id;
    private String name;
    private String author;
    private String shortDescription;

    public Book() {
    }

    public Book(Integer id, String name, String author, String shortDescription) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.shortDescription = shortDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(shortDescription, book.shortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, shortDescription);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                '}';
    }
}
