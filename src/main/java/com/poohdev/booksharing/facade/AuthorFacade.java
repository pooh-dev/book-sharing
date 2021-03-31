package com.poohdev.booksharing.facade;

import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.dto.NewAuthorDTO;

import java.util.List;

public interface AuthorFacade {
    List<AuthorDTO> getAllAuthors();
    List<AuthorDTO> findAuthorByName(String authorName);
    List<AuthorDTO> findAuthorByBookName(String bookName);
    AuthorDTO createAuthor(NewAuthorDTO author);
    AuthorDTO addBookToAuthor(Long authorId, Long bookId);
    AuthorDTO removeBookFromAuthor(Long authorId, Long bookId);
    void deleteAuthor(Long authorId);
}
