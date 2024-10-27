package org.example.Entity;

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
    @Column(name = "name")
    private String name;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "publication_year")
    private Integer publication_year;
    @Column(name = "volume")
    private Integer volume;


    //TODO: that's the way it's implemented, but it can be changed
    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author authorId;

    @OneToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genreId;

    @OneToOne
    @JoinColumn(name = "cover_type_id", referencedColumnName = "id")
    private CoverType coverTypeId;






    public Book() {
    }

    public Book(Integer id, String name, String shortDescription, Author authorId, Genre genreId, Integer publication_year, Integer volume, CoverType coverTypeId) {
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
