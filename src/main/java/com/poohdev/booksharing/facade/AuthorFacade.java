package com.poohdev.booksharing.facade;

import com.poohdev.booksharing.dto.AuthorDTO;

import java.util.List;

public interface AuthorFacade {
    List<AuthorDTO> getAllAuthors();
    List<AuthorDTO> findAuthorByName(String authorName);
    List<AuthorDTO> findAuthorByBookName(String bookName);
    AuthorDTO createAuthor(AuthorDTO author);
    AuthorDTO updateAuthor(AuthorDTO author);
    void deleteAuthor(Long authorId);
    AuthorDTO addBookToAuthor(Long authorId, Long bookId);
    AuthorDTO removeBookFromAuthor(Long authorId, Long bookId);
}
