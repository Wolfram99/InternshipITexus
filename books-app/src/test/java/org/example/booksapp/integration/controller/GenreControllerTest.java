package org.example.booksapp.integration.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.booksapp.entities.Genre;
import org.example.booksapp.repositories.GenreRepositoryJPA;
import org.example.booksapp.service.serviceimpl.GenreServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class GenreControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GenreRepositoryJPA repository;
    @Autowired
    private GenreServiceImpl service;
    private final List<Genre> genres = List.of(new Genre(null, "Драма"),new Genre(null, "Комедия"));

    @BeforeEach
    void setUp(){
        repository.saveAll(genres);
    }

    @AfterEach
    void after(){
        repository.deleteAll();
    }



    @Container
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16"));

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.jpa.generate-ddl", () -> true);
    }

    @Test
    void testAdd() throws Exception {
        Genre genre1 = new Genre(null, "Детектив");
        String genreJson = objectMapper.writeValueAsString(genre1);
        this.mockMvc.perform(post("/api/v0.1/genres")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(genreJson))
                .andExpect(status().isOk());
        var genre = repository.findByGenre("Детектив");
        assertThat(genres).isNotEmpty();
        assertEquals("Детектив", genre.get().getGenre());
    }


    @Test
    void testShowAll()throws Exception{

        var result = this.mockMvc.perform(get("/api/v0.1/genres"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertThat(result.getResponse().getContentAsString()).isEqualTo(new ObjectMapper().writeValueAsString(genres));
    }

    @Test
    void testFind()throws Exception{

        Genre findGenre = repository.findAll().stream().findFirst().get();
        this.mockMvc.perform(get("/api/v0.1/genres/{id}", findGenre.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(findGenre.getId()))
                .andExpect(jsonPath("$.genre").value(findGenre.getGenre()))
                .andReturn();
    }


    @Test
    void testDelete()throws Exception{

        Genre deleteGenre = repository.findAll().stream().findFirst().get();
        this.mockMvc.perform(delete("/api/v0.1/genres/{id}", deleteGenre.getId()))
                .andExpect(status().isOk());
        assertThat(repository.findAll().stream().map(Genre::getGenre).toList()).isEqualTo(genres.stream().filter(g-> !g.getGenre().startsWith(deleteGenre.getGenre())).map(Genre::getGenre).toList());
    }

    @Test
    void testUpdate() throws Exception {

        Genre updateGenre = repository.findByGenre("Драма").get();
        Integer idUpdateGenre = updateGenre.getId();
        updateGenre.setGenre("Драма_TEST_UPDATE");
        String genreJson = objectMapper.writeValueAsString(updateGenre);
        this.mockMvc.perform(put("/api/v0.1/genres")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(genreJson))
                .andExpect(status().isOk());
        var genre = repository.findByGenre("Драма_TEST_UPDATE");
        assertThat(genres).isNotEmpty();
        assertEquals(idUpdateGenre, genre.get().getId());
    }



}



