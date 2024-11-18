package org.example.Controllers;


import org.example.Entity.Book;
import org.example.Service.ServiceImpl.BookMongoDBServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v0.1/files")
public class WorkingFilesController {

    private final BookMongoDBServiceImpl service;

    @Autowired
    public WorkingFilesController(BookMongoDBServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/{idBook}")
    private HttpStatus upload(@RequestParam MultipartFile file, @PathVariable("idBook") Integer idBook) throws IOException {
        service.upload(idBook,file);
        return HttpStatus.OK;
    }

//    @PostMapping
//    private void download(){
//        service.download();
//    }
}
