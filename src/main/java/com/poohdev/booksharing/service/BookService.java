package com.poohdev.booksharing.service;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findById(Long bookId);
    Book findByIsbn(String isbn);
    List<Book> findByName(String name);
    List<Book> findByPriceRange(Double minPrice, Double maxPrice);
    List<Book> findByAuthor(Long authorId);
    Book createOrUpdateBook(Book book);
    void deleteBookById(Long bookId);
}
