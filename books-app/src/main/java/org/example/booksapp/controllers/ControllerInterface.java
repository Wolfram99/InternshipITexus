package org.example.booksapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerInterface<E> {

    ResponseEntity<List<E>> showAll();
    ResponseEntity<E> find(Integer id);
    HttpStatus add(E e);
    HttpStatus delete(Integer id);
    HttpStatus update(E e);

}
