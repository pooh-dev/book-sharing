package com.poohdev.booksharing.service;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();
    Author findById(Long authorId);
    List<Author> findByName(String name);
    List<Author> findByBookName(String bookName);
    Author createAuthor(Author author);
    Author addBook(Long authorId, Book book);
    Author deleteBook(Long authorId, Book book);
    void deleteAuthorById(Long authorId);
}
