package org.example.Controllers;

import org.example.Entity.Author;
import org.example.Entity.Book;
import org.example.Service.AuthorDMLService;
import org.example.Service.AuthorDQLService;
import org.example.Service.BookDMLService;
import org.example.Service.BookDQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0.1/books")
public class BookController implements ControllerInterface<Book>{

    private final BookDMLService dmlService;
    private final BookDQLService dqlService;


    @Autowired
    public BookController(@Qualifier("bookServiceImpl") BookDMLService dmlService, @Qualifier("bookServiceImpl") BookDQLService dqlService) {
        this.dmlService = dmlService;
        this.dqlService = dqlService;
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
}
