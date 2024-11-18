package org.example.Service.ServiceImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Service
public class BookMongoDBServiceImpl {

    private final GridFsTemplate repository;

    @Autowired
    public BookMongoDBServiceImpl(GridFsTemplate repository) {
        this.repository = repository;
    }

    public void upload(Integer bookId,MultipartFile file) throws IOException {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("fileName", file.getOriginalFilename());
        dbObject.put("contentType", file.getContentType());
        dbObject.put("size", file.getSize());
        dbObject.put("bookId", bookId);
        ObjectId id = repository.store(file.getInputStream(), file.getOriginalFilename(), dbObject);
        System.out.println(id.toString());
    }

}
