package com.poohdev.booksharing.facade;

import com.poohdev.booksharing.dto.BookDTO;

import java.util.List;

public interface BookFacade {
    List<BookDTO> getAllBooks();
    BookDTO findByIsbn(String isbn);
    List<BookDTO> findByAuthor(Long authorId);
    List<BookDTO> findByName(String name);
    List<BookDTO> findByPriceRange(Double minPrice, Double maxPrice);
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);
    void deleteBook(Long bookId);
}
