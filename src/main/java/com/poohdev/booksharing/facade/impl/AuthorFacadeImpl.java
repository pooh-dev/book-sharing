package com.poohdev.booksharing.facade.impl;

import com.poohdev.booksharing.converter.AuthorDtoConverter;
import com.poohdev.booksharing.converter.AuthorModelConverter;
import com.poohdev.booksharing.converter.BookDtoConverter;
import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.facade.AuthorFacade;
import com.poohdev.booksharing.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorFacadeImpl implements AuthorFacade {
    private final AuthorService authorService;
    private final ModelMapper authorMapper;

    public AuthorFacadeImpl(AuthorService authorService,
                            AuthorModelConverter authorModelConverter,
                            AuthorDtoConverter authorDtoConverter,
                            BookDtoConverter bookDtoConverter) {

        this.authorService = authorService;
        this.authorMapper = new ModelMapper();
        this.authorMapper.addConverter(authorModelConverter);
        this.authorMapper.addConverter(authorDtoConverter);
        this.authorMapper.addConverter(bookDtoConverter);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorService.findAllAuthors().stream()
                .map(author -> authorMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDTO> findAuthorByName(String name) {
        return authorService.findByName(name).stream()
                .map(author -> authorMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDTO> findAuthorByBookName(String bookName) {
        return authorService.findByBookName(bookName).stream()
                .map(author -> authorMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = authorService.createAuthor(authorMapper.map(authorDTO, Author.class));
        return authorMapper.map(author, AuthorDTO.class);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorService.deleteAuthorById(authorId);
    }

    @Override
    public AuthorDTO addBookToAuthor(Long authorId, BookDTO bookDTO) {
        Author author = authorService.addBookToAuthor(authorId, authorMapper.map(bookDTO, Book.class));
        return authorMapper.map(author, AuthorDTO.class);
    }
}
