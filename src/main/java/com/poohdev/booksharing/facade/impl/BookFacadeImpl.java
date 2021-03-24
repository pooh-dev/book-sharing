package com.poohdev.booksharing.facade.impl;

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
    public List<BookDTO> getBooksByAuthor(Long authorId) {
        return bookService.findByAuthor(authorId).stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }
}
