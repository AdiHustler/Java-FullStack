package com.library.service;

import com.library.entity.Author;
import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
}