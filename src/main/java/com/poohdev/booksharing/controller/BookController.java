package com.poohdev.booksharing.controller;

import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.facade.BookFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookFacade bookFacade;

    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookFacade.getAllBooks();
    }
}
