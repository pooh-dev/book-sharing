package com.poohdev.booksharing.facade;

import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.dto.BookDTO;

import java.util.List;

public interface AuthorFacade {
    List<AuthorDTO> getAllAuthors();
    List<AuthorDTO> findAuthorByName(String authorName);
    List<AuthorDTO> findAuthorByBookName(String bookName);
    AuthorDTO createAuthor(AuthorDTO author);
    void deleteAuthor(Long authorId);
    AuthorDTO addBookToAuthor(Long authorId, BookDTO bookDTO);
}
