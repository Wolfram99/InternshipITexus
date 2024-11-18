package org.example.Controllers;


import org.bson.types.Binary;
import org.example.Entity.Book;
import org.example.Entity.Icon;
import org.example.Service.ServiceImpl.IconServiceMongoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("api/v0.1/files")
public class WorkingFilesController {

    private final IconServiceMongoDbImpl service;

    @Autowired
    public WorkingFilesController(IconServiceMongoDbImpl service) {
        this.service = service;
    }


    @PostMapping("/add/{bookId}")
    public ResponseEntity<?> uploadIcon(@PathVariable("bookId") Integer bookId, @RequestParam("icon") MultipartFile icon) throws IOException {
        service.addIcon(bookId, icon);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/download/{bookId}")
    public String downloadIcon(@PathVariable("bookId") Integer id) {
        Icon icon = service.getPhoto(id);
//        Base64.getEncoder().encodeToString(icon.getImage().getData());
        return Base64.getEncoder().encodeToString(icon.getImage().getData());
    }



//    @PostMapping("/{idBook}")
//    private HttpStatus upload(@RequestParam("file") MultipartFile file, @PathVariable("idBook") Integer idBook) throws IOException {
//        service.addFile(idBook,file);
//        return HttpStatus.OK;
//    }
//
////    @PostMapping("/upload")
////    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file, @PathVariable("idBook") Integer idBook) throws IOException {
////        return new ResponseEntity<>(service.addFile( idBook,file), HttpStatus.OK);
////    }
//
//    @GetMapping("/download/{id}")
//    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
//        LoadFile loadFile = service.downloadFile(id);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(loadFile.getFileType() ))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + loadFile.getFilename() + "\"")
//                .body(new ByteArrayResource(loadFile.getFile()));
//    }

}
