package com.poohdev.booksharing.service;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findByIsbn(String isbn);
    List<Book> findByName(String name);
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Book> findByAuthor(Author author);
    Book createBook(Book book);
    void deleteBookById(Long bookId);
    Book changePrice(Book book, Double newPrice);
    Book updateDescription(Book book, String newDescription);
}
