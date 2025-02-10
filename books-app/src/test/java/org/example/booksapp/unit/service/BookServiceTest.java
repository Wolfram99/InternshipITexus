package org.example.booksapp.unit.service;


import org.example.booksapp.entities.Book;
import org.example.booksapp.repositories.BookRepositoryJPA;
import org.example.booksapp.service.serviceimpl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepositoryJPA bookRepository;

    private Book book;

    @BeforeEach
    void setUp(){
        book = new Book();
    }

    @Test
    void testFindById() {
        book.setId(2);
        book.setName("Горе от ума");
        Mockito.when(bookRepository.findById(2)).thenReturn(Optional.of(book));
        Book result = bookService.findById(2);
        assertNotNull(result);
        assertEquals("Горе от ума", result.getName());
    }





}
