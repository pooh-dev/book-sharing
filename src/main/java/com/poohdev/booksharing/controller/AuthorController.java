package com.poohdev.booksharing.controller;

import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.facade.impl.AuthorFacadeImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        return new ResponseEntity<>(authorFacade.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<AuthorDTO>> findAuthorByName(@PathVariable String name) {
        return new ResponseEntity<>(authorFacade.findAuthorByName(name), HttpStatus.OK);
    }

    @GetMapping("/book/{bookName}")
    public ResponseEntity<List<AuthorDTO>> findAuthorByBookName(@PathVariable String bookName) {
        return new ResponseEntity<>(authorFacade.findAuthorByBookName(bookName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO author) {
        return new ResponseEntity<>(authorFacade.createAuthor(author), HttpStatus.OK);
    }

    @PutMapping("/{authorId}/addBook/{bookId}")
    public ResponseEntity<AuthorDTO> addBook(@PathVariable Long authorId, @PathVariable Long bookId) {
        return new ResponseEntity<>(authorFacade.addBookToAuthor(authorId, bookId), HttpStatus.OK);
    }

    @PutMapping("/{authorId}/removeBook/{bookId}")
    public ResponseEntity<AuthorDTO> removeBook(@PathVariable Long authorId, @PathVariable Long bookId) {
        return new ResponseEntity<>(authorFacade.removeBookFromAuthor(authorId, bookId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorFacade.deleteAuthor(id);
    }
}
