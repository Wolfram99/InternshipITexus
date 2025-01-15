package org.example.booksapp.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "birth_year")
    private Integer brithYear;


    public Author() {
    }

    public Author(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Author(Integer id, String name, String patronymic, String surname, Integer brithYear) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.brithYear = brithYear;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBrithYear() {
        return brithYear;
    }

    public void setBrithYear(Integer brithYear) {
        this.brithYear = brithYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(patronymic, author.patronymic) && Objects.equals(surname, author.surname) && Objects.equals(brithYear, author.brithYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, patronymic, surname, brithYear);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", surname='" + surname + '\'' +
                ", brithYear=" + brithYear +
                '}';
    }
}
