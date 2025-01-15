package org.example.booksapp.unit.controller;


import org.example.booksapp.controllers.AuthorController;
import org.example.booksapp.entities.Author;
import org.example.booksapp.service.serviceimpl.AuthorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest(AuthorController.class)
class AuthorControllerTest {

    @InjectMocks
    private AuthorController controller;
    @Mock
    private AuthorServiceImpl service;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testShowAll() throws Exception {
        mockMvc.perform(get("/api/v0.1/authors"))
                .andExpect(status().isOk());
        verify(service, times(1)).findAll();
    }

    @Test
    void testFind() throws Exception {
        Author author = new Author(1, "John", "Johns");
        when(service.findById(1)).thenReturn(author);
        mockMvc.perform(get("/api/v0.1/authors/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.surname").value("Johns"));
        verify(service, times(1)).findById(1);
    }

    @Test
    void testAdd() throws Exception {
       mockMvc.perform(post("/api/v0.1/authors"))
                .andExpect(status().isOk());
       verify(service, times(1)).insert(new Author());
    }




}
