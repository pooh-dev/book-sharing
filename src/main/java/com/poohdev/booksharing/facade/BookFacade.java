package com.poohdev.booksharing.facade;

import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.dto.NewBookDTO;
import com.poohdev.booksharing.dto.UpdateBookDescriptionDTO;
import com.poohdev.booksharing.dto.UpdateBookPriceDTO;

import java.util.List;

public interface BookFacade {
    List<BookDTO> getAllBooks();
    BookDTO findByIsbn(String isbn);
    List<BookDTO> findByAuthor(Long authorId);
    List<BookDTO> findByName(String name);
    List<BookDTO> findByPriceRange(Double minPrice, Double maxPrice);
    BookDTO createBook(NewBookDTO bookDTO);
    BookDTO updateDescription(UpdateBookDescriptionDTO bookDTO);
    BookDTO changePrice(UpdateBookPriceDTO bookDTO);
    void deleteBook(Long bookId);
}
