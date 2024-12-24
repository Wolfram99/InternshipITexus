package org.example.booksapp.controllers;


import org.example.booksapp.entities.CoverType;
import org.example.booksapp.Service.CoverTypeDMLService;
import org.example.booksapp.Service.CoverTypeDQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0.1/cover_types")
public class CovetTypeController implements ControllerInterface<CoverType>{


    private final CoverTypeDMLService dmlService;
    private final CoverTypeDQLService dqlService;


    @Autowired
    public CovetTypeController(@Qualifier("coverTypeServiceImpl") CoverTypeDMLService dmlService, @Qualifier("coverTypeServiceImpl") CoverTypeDQLService dqlService) {
        this.dmlService = dmlService;
        this.dqlService = dqlService;
    }
    @Override
    @GetMapping()
    public ResponseEntity<List<CoverType>> showAll() {
        return new ResponseEntity<>(dqlService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CoverType> find(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(dqlService.findById(id), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public HttpStatus add(@ModelAttribute CoverType coverType) {
        dmlService.insert(coverType);

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
    public HttpStatus update(@ModelAttribute CoverType coverType) {
        dmlService.update(coverType);

        return HttpStatus.OK;
    }
}
