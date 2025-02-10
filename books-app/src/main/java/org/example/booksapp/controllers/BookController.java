package org.example.booksapp.controllers;


import org.example.booksapp.entities.Book;

import org.example.booksapp.feignclient.WorkingFilesFeignClient;
import org.example.booksapp.service.BookDMLService;
import org.example.booksapp.service.BookDQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v0.1/books")
public class BookController implements ControllerInterface<Book>{

    private final BookDMLService dmlService;
    private final BookDQLService dqlService;
    private final WorkingFilesFeignClient feignClient;



    @Autowired
    public BookController(@Qualifier("bookServiceImpl") BookDMLService dmlService,
                          @Qualifier("bookServiceImpl") BookDQLService dqlService, WorkingFilesFeignClient feignClient) {
        this.dmlService = dmlService;
        this.dqlService = dqlService;

        this.feignClient = feignClient;
    }
    @Override
    @GetMapping()
    public ResponseEntity<List<Book>> showAll() {
        return new ResponseEntity<>(dqlService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Book> find(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(dqlService.findById(id), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public HttpStatus add(@ModelAttribute Book book) {
        dmlService.insert(book);

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
    public HttpStatus update(@ModelAttribute Book book) {
        dmlService.update(book);

        return HttpStatus.OK;
    }



    @GetMapping("/download-files")
    public ResponseEntity<ByteArrayResource> download(){

        try {
            return feignClient.download(Integer.parseInt("111"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




}
