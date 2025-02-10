package org.example.Models;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

    private Integer id;
    private String name;
    private String shortDescription;
    private Integer authorId;
    private Integer genreId;
    private Integer publication_year;
    private Integer volume;
    private Integer coverTypeId;

    public Book() {
    }

    public Book(Integer id, String name, String shortDescription, Integer authorId, Integer genreId, Integer publication_year, Integer volume, Integer coverTypeId) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.authorId = authorId;
        this.genreId = genreId;
        this.publication_year = publication_year;
        this.volume = volume;
        this.coverTypeId = coverTypeId;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_year) {
        this.publication_year = publication_year;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getCoverTypeId() {
        return coverTypeId;
    }

    public void setCoverTypeId(Integer coverTypeId) {
        this.coverTypeId = coverTypeId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(shortDescription, book.shortDescription) && Objects.equals(authorId, book.authorId) && Objects.equals(genreId, book.genreId) && Objects.equals(publication_year, book.publication_year) && Objects.equals(volume, book.volume) && Objects.equals(coverTypeId, book.coverTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortDescription, authorId, genreId, publication_year, volume, coverTypeId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", authorId=" + authorId +
                ", genreId=" + genreId +
                ", publication_year=" + publication_year +
                ", volume=" + volume +
                ", coverTypeId=" + coverTypeId +
                '}';
    }
}
