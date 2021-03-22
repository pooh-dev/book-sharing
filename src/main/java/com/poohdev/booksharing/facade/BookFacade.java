package com.poohdev.booksharing.facade;

import com.poohdev.booksharing.dto.BookDTO;

import java.util.List;

public interface BookFacade {
    List<BookDTO> getAllBooks();
    List<BookDTO> getBooksByAuthor(Long authorId);
}
