package com.poohdev.booksharing.facade.impl;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.facade.AuthorFacade;
import com.poohdev.booksharing.service.AuthorService;
import com.poohdev.booksharing.service.BookService;
import com.poohdev.booksharing.utils.BookSharingModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorFacadeImpl implements AuthorFacade {
    private final AuthorService authorService;
    private final BookService bookService;
    private final BookSharingModelMapper modelMapper;

    public AuthorFacadeImpl(AuthorService authorService,
                            BookService bookService,
                            BookSharingModelMapper modelMapper) {

        this.authorService = authorService;
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorService.findAllAuthors().stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDTO> findAuthorByName(String name) {
        return authorService.findByName(name).stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDTO> findAuthorByBookName(String bookName) {
        return authorService.findByBookName(bookName).stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = authorService.createAuthor(modelMapper.map(authorDTO, Author.class));
        return modelMapper.map(author, AuthorDTO.class);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorService.deleteAuthorById(authorId);
    }

    @Override
    public AuthorDTO addBookToAuthor(Long authorId, Long bookId) {
        Book book = bookService.findById(bookId);
        Author author = authorService.addBook(authorId, book);
        return modelMapper.map(author, AuthorDTO.class);
    }

    @Override
    public AuthorDTO deleteBookFromAuthor(Long authorId, Long bookId) {
        Book book = bookService.findById(bookId);
        Author author = authorService.deleteBook(authorId, book);
        return modelMapper.map(author, AuthorDTO.class);
    }
}
