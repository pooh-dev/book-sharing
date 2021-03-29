package com.poohdev.booksharing.controller;

import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.facade.impl.BookFacadeImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookFacadeImpl bookFacade;

    public BookController(BookFacadeImpl bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return new ResponseEntity<>(bookFacade.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable Long authorId) {
        return new ResponseEntity<>(bookFacade.findByAuthor(authorId), HttpStatus.OK);
    }

    @GetMapping("/name/{bookName}")
    public ResponseEntity<List<BookDTO>> getBooksByName(@PathVariable String bookName) {
        return new ResponseEntity<>(bookFacade.findByName(bookName), HttpStatus.OK);
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookDTO> getBookByIsbn(@PathVariable String isbn) {
        return new ResponseEntity<>(bookFacade.findByIsbn(isbn), HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<BookDTO>> getBooksByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return new ResponseEntity<>(bookFacade.findByPriceRange(min, max), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookFacade.createBook(bookDTO), HttpStatus.OK);
    }

    @PutMapping("/description")
    public ResponseEntity<BookDTO> updateDescription(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookFacade.updateDescription(bookDTO), HttpStatus.OK);
    }

    @PutMapping("/price")
    public ResponseEntity<BookDTO> changePrice(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookFacade.changePrice(bookDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookFacade.deleteBook(id);
    }
}
