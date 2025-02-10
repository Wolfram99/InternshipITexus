package org.example.booksapp.unit.repositories;

import org.example.booksapp.entities.Genre;
import org.example.booksapp.repositories.GenreRepositoryJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GenreRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GenreRepositoryJPA repository;

    @Test
    void testFindById() {
        this.entityManager.persist(new Genre(null, "TEST"));
        Genre genre = this.repository.findByGenre("TEST").get();
        assertThat(genre.getGenre()).isEqualTo("TEST");

    }

}