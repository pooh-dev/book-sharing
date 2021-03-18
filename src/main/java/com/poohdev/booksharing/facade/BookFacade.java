package com.poohdev.booksharing.facade;

import com.poohdev.booksharing.converter.BookConverter;
import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookFacade {
    private final BookService bookService;
    private final ModelMapper modelMapper;

    public BookFacade(BookService bookService, BookConverter bookConverter) {
        this.bookService = bookService;
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(bookConverter);
    }

    public List<BookDTO> getAllBooks() {
        return bookService.findAllBooks().stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }
}
