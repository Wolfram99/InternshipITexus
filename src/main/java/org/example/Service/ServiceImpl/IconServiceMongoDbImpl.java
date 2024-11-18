package org.example.Service.ServiceImpl;


import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.example.Entity.Icon;
import org.example.repositories.IconMongoDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class IconServiceMongoDbImpl {


    private final IconMongoDbRepository repository;

    @Autowired
    public IconServiceMongoDbImpl(IconMongoDbRepository repository) {
        this.repository = repository;
    }





    public String addIcon(Integer bookId, MultipartFile file) throws IOException {
        Icon icon = new Icon(bookId);
        icon.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        icon = repository.insert(icon);
        System.out.println(icon.getId());
        return icon.getId();
    }



    public Icon getPhoto(Integer bookId) {
        return repository.findByBookId(bookId).get();
    }
}




//
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBObject;
//import com.mongodb.client.gridfs.model.GridFSFile;
//import org.bson.ByteBuf;
//import org.bson.types.ObjectId;
//import org.example.Entity.LoadFile;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.gridfs.GridFsOperations;
//import org.springframework.data.mongodb.gridfs.GridFsTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//import java.nio.ByteBuffer;
//
//
//@Service
//public class BookMongoDBServiceImpl {
//
//    private final GridFsTemplate template;
//    private final GridFsOperations operations;
//
//    @Autowired
//    public BookMongoDBServiceImpl(GridFsTemplate template, GridFsOperations operations) {
//        this.template = template;
//        this.operations = operations;
//    }
//
//
//    //    public String addFile(MultipartFile upload) throws IOException {
////
////        DBObject metadata = new BasicDBObject();
////        metadata.put("fileSize", upload.getSize());
////
////        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);
////
////        return fileID.toString();
////    }
//
//
//    public LoadFile downloadFile(String id) throws IOException {
//
//        GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );
//
//        LoadFile loadFile = new LoadFile();
//
//        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
//            loadFile.setFilename( gridFSFile.getFilename() );
//
//            loadFile.setFileType( gridFSFile.getMetadata().get("contentType").toString() );
//
//            loadFile.setFileSize(gridFSFile.getMetadata().get("size").toString() );
//
//            loadFile.setFile(Byte.parseByte(operations.getResource(gridFSFile).getInputStream()));
//        }
//
//        return loadFile;
//    }
//
//
//
////    private final GridFsTemplate repository;
////
////    @Autowired
////    public BookMongoDBServiceImpl(GridFsTemplate repository) {
////        this.repository = repository;
////    }
////
//    public void addFile(Integer bookId,MultipartFile file) throws IOException {
//        DBObject dbObject = new BasicDBObject();
//        dbObject.put("fileName", file.getOriginalFilename());
//        dbObject.put("contentType", file.getContentType());
//        dbObject.put("size", file.getSize());
//        dbObject.put("bookId", bookId);
//        ObjectId id = template.store(file.getInputStream(), file.getOriginalFilename(), dbObject);
//        System.out.println(id.toString());
//    }
////
////    public MultipartFile download(ObjectId id){
////        GridFSFile file = repository.findOne(Query.query(Criteria.where("_id").is(id)));
////
////
////    }
//}
