package com.poohdev.booksharing.facade.impl;

import com.poohdev.booksharing.converter.BookDtoConverter;
import com.poohdev.booksharing.converter.BookModelConverter;
import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.facade.BookFacade;
import com.poohdev.booksharing.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookFacadeImpl implements BookFacade {
    private final BookService bookService;
    private final ModelMapper bookMapper;

    public BookFacadeImpl(BookService bookService,
                          BookModelConverter bookModelConverter,
                          BookDtoConverter bookDtoConverter) {

        this.bookService = bookService;
        this.bookMapper = new ModelMapper();
        this.bookMapper.addConverter(bookModelConverter);
        this.bookMapper.addConverter(bookDtoConverter);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookService.findAllBooks().stream()
                .map(book -> bookMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBooksByAuthor(Long authorId) {
        return bookService.findByAuthor(authorId).stream()
                .map(book -> bookMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }
}
