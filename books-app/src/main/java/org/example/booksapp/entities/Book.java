package org.example.booksapp.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "publication_year")
    private Integer publicationYear;
    @Column(name = "volume",nullable = false)
    private Integer volume;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Author authorId;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Genre genreId;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private CoverType coverTypeId;



    public Book() {
    }


    public Book(Integer id, String name, String shortDescription, Integer publicationYear, Integer volume,
                Author authorId, Genre genreId, CoverType coverTypeId) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.publicationYear = publicationYear;
        this.volume = volume;
        this.authorId = authorId;
        this.genreId = genreId;
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

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }

    public CoverType getCoverTypeId() {
        return coverTypeId;
    }

    public void setCoverTypeId(CoverType coverTypeId) {
        this.coverTypeId = coverTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(shortDescription, book.shortDescription) && Objects.equals(publicationYear, book.publicationYear) && Objects.equals(volume, book.volume) && Objects.equals(authorId, book.authorId) && Objects.equals(genreId, book.genreId) && Objects.equals(coverTypeId, book.coverTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortDescription, publicationYear, volume, authorId, genreId, coverTypeId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name +
                ", shortDescription='" + shortDescription +
                ", publicationYear=" + publicationYear +
                ", volume=" + volume +
                ", authorId=" + authorId +
                ", genreId=" + genreId +
                ", coverTypeId=" + coverTypeId +'}';
    }
}
