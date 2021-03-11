package com.poohdev.booksharing.service.impl;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.repository.BookRepository;
import com.poohdev.booksharing.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findByNameContains(name);
    }

    @Override
    public List<Book> findByPriceBetween(Double minPrice, Double maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        return findAllBooks().stream()
                .filter(book -> book.getAuthors().contains(author))
                .collect(Collectors.toList());
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book changePrice(Book book, Double newPrice) {
        book.setPrice(newPrice);
        return bookRepository.save(book);
    }

    @Override
    public Book updateDescription(Book book, String newDescription) {
        book.setDescription(newDescription);
        return bookRepository.save(book);
    }
}
