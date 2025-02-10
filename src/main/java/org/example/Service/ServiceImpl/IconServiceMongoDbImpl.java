package org.example.Service.ServiceImpl;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.apache.commons.io.IOUtils;

import org.example.Entity.Model.Icon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class IconServiceMongoDbImpl {

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;

    public String upload(Integer bookId, MultipartFile upload) throws IOException {

        DBObject metadata = new BasicDBObject();
        metadata.put("size", upload.getSize());
        metadata.put("bookId", bookId);

        Object fileID = template.store(upload.getInputStream(), upload.getOriginalFilename(), upload.getContentType(), metadata);

        return fileID.toString();
    }


    public Icon download(Integer bookId) throws IOException {

        GridFSFile gridFSFile = template.findOne(new Query(Criteria.where("metadata.bookId").is(bookId)));
        Icon icon = new Icon();

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            icon.setFileName(gridFSFile.getFilename());
            icon.setBookId(Integer.parseInt(gridFSFile.getMetadata().get("bookId").toString()));
            icon.setContentType(gridFSFile.getMetadata().get("_contentType").toString());
            icon.setSize(gridFSFile.getMetadata().get("size").toString());
            icon.setFile(IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()));
        }
        return icon;
    }


}
