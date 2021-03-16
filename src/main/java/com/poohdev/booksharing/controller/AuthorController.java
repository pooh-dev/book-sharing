package com.poohdev.booksharing.controller;

import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.facade.AuthorFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthorFacade authorFacade;

    public AuthorController(AuthorFacade authorFacade) {
        this.authorFacade = authorFacade;
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors() {
        return authorFacade.getAllAuthors();
    }
}
