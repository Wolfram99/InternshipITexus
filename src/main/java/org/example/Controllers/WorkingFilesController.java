package org.example.Controllers;

import org.example.Entity.Model.Icon;
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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("api/v0.1/files")
public class WorkingFilesController {

    private final IconServiceMongoDbImpl service;

    @Autowired
    public WorkingFilesController(IconServiceMongoDbImpl service) {
        this.service = service;
    }


    @PostMapping("/upload/{id}")
    public ResponseEntity<?> upload(@RequestParam("icon")MultipartFile file, @PathVariable("id") Integer bookId) throws IOException {
        return new ResponseEntity<>(service.upload(bookId ,file), HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable("id") Integer bookId) throws IOException {
        Icon icon = service.download(bookId);

        String URLEncodedFileName = URLEncoder.encode(icon.getFileName(), StandardCharsets.UTF_8);
        String ResultFileName = URLEncodedFileName.replace('+', ' ');
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(icon.getContentType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=\"utf8'ru-ru'"+ResultFileName+"\"")
                .body(new ByteArrayResource(icon.getFile()));
    }

}
