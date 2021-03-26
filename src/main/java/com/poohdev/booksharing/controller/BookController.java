package com.poohdev.booksharing.controller;

import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.facade.impl.BookFacadeImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookFacadeImpl bookFacade;

    public BookController(BookFacadeImpl bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookFacade.getAllBooks();
    }

    @GetMapping("/books/author/{authorId}")
    public List<BookDTO> getBooksByAuthor(@PathVariable Long authorId) {
        return bookFacade.findByAuthor(authorId);
    }
}
