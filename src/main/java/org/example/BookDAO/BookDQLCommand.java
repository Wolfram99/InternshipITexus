package org.example.BookDAO;

import org.example.Models.Book;

import java.util.List;

public interface BookDQLCommand {

   Book findById(Integer id);
   List<Book> findAll();
}
