package org.example.Models;

import java.io.Serializable;
import java.util.Objects;

public class Author{

    private Integer id;
    private String name;
    private String patronymic;
    private String surname;
    private Integer brith_year;


    public Author() {
    }

    public Author(Integer id, String name, String patronymic, String surname, Integer brith_year) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.brith_year = brith_year;
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

    public Integer getBrith_year() {
        return brith_year;
    }

    public void setBrith_year(Integer brith_year) {
        this.brith_year = brith_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(patronymic, author.patronymic) && Objects.equals(surname, author.surname) && Objects.equals(brith_year, author.brith_year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, patronymic, surname, brith_year);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", surname='" + surname + '\'' +
                ", brith_year=" + brith_year +
                '}';
    }
}
