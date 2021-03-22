package com.poohdev.booksharing.controller;

import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.facade.impl.AuthorFacadeImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorFacadeImpl authorFacade;

    public AuthorController(AuthorFacadeImpl authorFacade) {
        this.authorFacade = authorFacade;
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors() {
        return authorFacade.getAllAuthors();
    }

    @GetMapping("/authors/{name}")
    public List<AuthorDTO> findAuthorByName(@PathVariable String name) {
        return authorFacade.findAuthorByName(name);
    }

    @GetMapping("/authors/book/{bookName}")
    public List<AuthorDTO> findAuthorByBookName(@PathVariable String bookName) {
        return authorFacade.findAuthorByBookName(bookName);
    }
}
