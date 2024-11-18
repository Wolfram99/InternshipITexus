package org.example.Entity;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "icons")
public class Icon {
    @Id
    private String id;
    private Integer bookId;
    private Binary image;

    public Icon() {
    }

    public Icon(String id) {
        this.id = id;
    }

    public Icon(Integer bookId) {
        this.bookId = bookId;
    }

    public Icon(String id, Integer bookId) {
        this.id = id;
        this.bookId = bookId;
    }

    public Icon(String id, Integer bookId, Binary image) {
        this.id = id;
        this.bookId = bookId;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Icon icon = (Icon) o;
        return Objects.equals(id, icon.id) && Objects.equals(bookId, icon.bookId) && Objects.equals(image, icon.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, image);
    }

    @Override
    public String toString() {
        return "Icon{" +
                "id='" + id + '\'' +
                ", bookId=" + bookId +
                ", image=" + image +
                '}';
    }
}