package org.example.booksapp.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@FeignClient(value = "working-files", url = "localhost:8080/working-files/api/v0.1/files")
public interface WorkingFilesFeignClient {


    @GetMapping("/download/{id}")
    ResponseEntity<ByteArrayResource> download(@PathVariable("id") Integer bookId) throws IOException ;
}
