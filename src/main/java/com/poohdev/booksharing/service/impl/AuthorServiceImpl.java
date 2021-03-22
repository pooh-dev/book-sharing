package com.poohdev.booksharing.service.impl;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.repository.AuthorRepository;
import com.poohdev.booksharing.service.AuthorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author findById(Long authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if (!optionalAuthor.isPresent()) {
            throw new IllegalArgumentException("There is no Author with given id.");
        }
        return optionalAuthor.get();
    }

    @Override
    public List<Author> findByName(String name) {
        return authorRepository.findByFullNameContains(name);
    }

    @Override
    public List<Author> findByBookName(String bookName) {
        Predicate<Author> containsBookName = author -> author.getBooks().stream()
                .anyMatch(book -> StringUtils.containsIgnoreCase(book.getName(), bookName));

        return findAllAuthors().stream()
                .filter(containsBookName)
                .collect(Collectors.toList());
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public Author addBookToAuthor(Long authorId, Book book) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if (!optionalAuthor.isPresent()) {
            throw new IllegalArgumentException("There is no Author with given id");
        }

        Author author = optionalAuthor.get();
        author.getBooks().add(book);
        return authorRepository.save(author);
    }
}
