package org.example.booksapp.controllers;


import org.example.booksapp.entities.Genre;
import org.example.booksapp.service.GenreDMLService;
import org.example.booksapp.service.GenreDQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0.1/genres")
public class GenreController implements ControllerInterface<Genre>{


    private final GenreDMLService dmlService;
    private final GenreDQLService dqlService;


    @Autowired
    public GenreController(@Qualifier("genreServiceImpl") GenreDMLService dmlService, @Qualifier("genreServiceImpl") GenreDQLService dqlService) {
        this.dmlService = dmlService;
        this.dqlService = dqlService;
    }
    @Override
    @GetMapping()
    public ResponseEntity<List<Genre>> showAll() {
        return new ResponseEntity<>(dqlService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Genre> find(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(dqlService.findById(id), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public HttpStatus add(@ModelAttribute Genre genre) {
        dmlService.insert(genre);

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
    public HttpStatus update(@ModelAttribute Genre genre) {
        dmlService.update(genre);

        return HttpStatus.OK;
    }
}
