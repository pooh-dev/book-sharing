package com.poohdev.booksharing.facade;

import com.poohdev.booksharing.dto.AuthorDTO;

import java.util.List;

public interface AuthorFacade {
    List<AuthorDTO> getAllAuthors();
    List<AuthorDTO> findAuthorByName(String authorName);
    List<AuthorDTO> findAuthorByBookName(String bookName);
    AuthorDTO createAuthor(AuthorDTO author);
    AuthorDTO addBookToAuthor(Long authorId, Long bookId);
    AuthorDTO removeBookFromAuthor(Long authorId, Long bookId);
    void deleteAuthor(Long authorId);
}
