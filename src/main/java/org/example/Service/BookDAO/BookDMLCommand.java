package org.example.Service.BookDAO;

import org.example.Models.Book;

public interface BookDMLCommand {

    void insert(Book newBook);
    void update(Book editBook);
    void delete(Integer id);
}
