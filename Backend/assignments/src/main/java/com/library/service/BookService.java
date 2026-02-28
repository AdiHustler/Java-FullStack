package com.library.service;

import com.library.entity.Book;
import java.util.List;

public interface BookService {

    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
}