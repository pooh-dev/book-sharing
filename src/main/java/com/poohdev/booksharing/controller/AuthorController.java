package com.poohdev.booksharing.controller;

import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.facade.impl.AuthorFacadeImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorFacadeImpl authorFacade;

    public AuthorController(AuthorFacadeImpl authorFacade) {
        this.authorFacade = authorFacade;
    }

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorFacade.getAllAuthors();
    }

    @GetMapping("/{name}")
    public List<AuthorDTO> findAuthorByName(@PathVariable String name) {
        return authorFacade.findAuthorByName(name);
    }

    @GetMapping("/book/{bookName}")
    public List<AuthorDTO> findAuthorByBookName(@PathVariable String bookName) {
        return authorFacade.findAuthorByBookName(bookName);
    }

    @PostMapping
    public AuthorDTO createAuthor(@RequestBody AuthorDTO author) {
        return authorFacade.createAuthor(author);
    }

    @PutMapping("/{authorId}/addBook/{bookId}")
    public AuthorDTO addBook(@PathVariable Long authorId, @PathVariable Long bookId) {
        return authorFacade.addBookToAuthor(authorId, bookId);
    }

    @PutMapping("/{authorId}/deleteBook/{bookId}")
    public AuthorDTO deleteBook(@PathVariable Long authorId, @PathVariable Long bookId) {
        return authorFacade.deleteBookFromAuthor(authorId, bookId);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorFacade.deleteAuthor(id);
    }
}
