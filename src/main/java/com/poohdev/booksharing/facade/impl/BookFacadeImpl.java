package com.poohdev.booksharing.facade.impl;

import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.facade.BookFacade;
import com.poohdev.booksharing.service.BookService;
import com.poohdev.booksharing.utils.BookSharingModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookFacadeImpl implements BookFacade {
    private final BookService bookService;
    private final BookSharingModelMapper modelMapper;

    public BookFacadeImpl(BookService bookService, BookSharingModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookService.findAllBooks().stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findByIsbn(String isbn) {
        return modelMapper.map(bookService.findByIsbn(isbn), BookDTO.class);
    }

    @Override
    public List<BookDTO> findByAuthor(Long authorId) {
        return bookService.findByAuthor(authorId).stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findByName(String name) {
        return bookService.findByName(name).stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findByPriceRange(Double minPrice, Double maxPrice) {
        return bookService.findByPriceRange(minPrice, maxPrice).stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookService.createOrUpdateBook(modelMapper.map(bookDTO, Book.class));
        return modelMapper.map(book, BookDTO.class);
    }

    @Override
    public BookDTO updateDescription(BookDTO bookDTO) {
        Book book = bookService.findById(bookDTO.getId());
        book.setDescription(bookDTO.getDescription());
        return modelMapper.map(bookService.createOrUpdateBook(book), BookDTO.class);
    }

    @Override
    public BookDTO changePrice(BookDTO bookDTO) {
        Book book = bookService.findById(bookDTO.getId());
        book.setPrice(bookDTO.getPrice());
        return modelMapper.map(bookService.createOrUpdateBook(book), BookDTO.class);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookService.deleteBookById(bookId);
    }
}
