package org.example.booksapp.controllers;


import org.example.booksapp.entities.Author;
import org.example.booksapp.Service.AuthorDMLService;
import org.example.booksapp.Service.AuthorDQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0.1/authors")
public class AuthorController implements ControllerInterface<Author>{

    private final AuthorDMLService dmlService;
    private final AuthorDQLService dqlService;


    @Autowired
    public AuthorController(@Qualifier("authorServiceImpl") AuthorDMLService dmlService,@Qualifier("authorServiceImpl") AuthorDQLService dqlService) {
        this.dmlService = dmlService;
        this.dqlService = dqlService;
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<Author>> showAll() {
        return new ResponseEntity<>(dqlService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Author> find(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(dqlService.findById(id), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public HttpStatus add(@ModelAttribute Author author) {
        dmlService.insert(author);

        return HttpStatus.OK;
    }

    @Override
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Integer id) {
        dmlService.delete(id);
        return null;
    }

    @Override
    @PutMapping
    public HttpStatus update(@ModelAttribute Author author) {
        dmlService.update(author);

        return HttpStatus.OK;
    }
}
