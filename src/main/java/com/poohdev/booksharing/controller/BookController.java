package com.poohdev.booksharing.controller;

import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.dto.NewBookDTO;
import com.poohdev.booksharing.dto.UpdateBookDescriptionDTO;
import com.poohdev.booksharing.dto.UpdateBookPriceDTO;
import com.poohdev.booksharing.facade.impl.BookFacadeImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookFacadeImpl bookFacade;

    public BookController(BookFacadeImpl bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookFacade.getAllBooks();
    }

    @GetMapping("/author/{authorId}")
    public List<BookDTO> getBooksByAuthor(@PathVariable Long authorId) {
        return bookFacade.findByAuthor(authorId);
    }

    @GetMapping("/name/{bookName}")
    public List<BookDTO> getBooksByName(@PathVariable String bookName) {
        return bookFacade.findByName(bookName);
    }

    @GetMapping("/isbn/{isbn}")
    public BookDTO getBookByIsbn(@PathVariable String isbn) {
        return bookFacade.findByIsbn(isbn);
    }

    @GetMapping("/price")
    public List<BookDTO> getBooksByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        return bookFacade.findByPriceRange(min, max);
    }

    @PostMapping
    public BookDTO createBook(@RequestBody @Valid NewBookDTO bookDTO) {
        return bookFacade.createBook(bookDTO);
    }

    @PutMapping("/description")
    public BookDTO updateDescription(@RequestBody @Valid UpdateBookDescriptionDTO bookDTO) {
        return bookFacade.updateDescription(bookDTO);
    }

    @PutMapping("/price")
    public BookDTO changePrice(@RequestBody @Valid UpdateBookPriceDTO bookDTO) {
        return bookFacade.changePrice(bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookFacade.deleteBook(id);
    }
}
