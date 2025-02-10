package org.example.Entity.Model;

import org.springframework.data.mongodb.core.mapping.Document;

public class Icon {

    private String fileName;
    private Integer bookId;
    private String contentType;
    private String size;
    private byte[] file;

    public Icon() {
    }

    public Icon(String fileName, Integer bookId, String contentType, String size, byte[] file) {
        this.bookId = bookId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.size = size;
        this.file = file;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}