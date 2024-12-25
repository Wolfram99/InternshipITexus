package org.example.workingfiles.services;

import org.example.workingfiles.entities.Icon;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface IconServiceMongoDb {

    String upload(Integer bookId, MultipartFile upload) throws IOException;
    Icon download(Integer bookId) throws IOException;
}










