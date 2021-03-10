package com.poohdev.booksharing.service;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();
    List<Author> findByName(String name);
    List<Author> findByBookName(String bookName);
    Author createAuthor(Author author);
    void deleteAuthorById(Long authorId);
    Author addBookToAuthor(Author author, Book book);
}
