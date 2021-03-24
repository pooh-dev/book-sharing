package com.poohdev.booksharing.converter;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.service.BookService;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthorDtoConverter implements Converter<AuthorDTO, Author> {

    private final BookService bookService;

    public AuthorDtoConverter(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Author convert(MappingContext<AuthorDTO, Author> context) {
        AuthorDTO authorDTO = context.getSource();

        Author author = new Author();
        if (authorDTO.getId() != null) {
            author.setId(authorDTO.getId());
        }
        author.setFullName(authorDTO.getFullName());
        author.setAbout(authorDTO.getAbout());

        if (CollectionUtils.isNotEmpty(authorDTO.getBookIds())) {
            Set<Book> books = authorDTO.getBookIds().stream()
                    .map(bookService::findById)
                    .collect(Collectors.toSet());
            author.setBooks(books);
        }

        return author;
    }
}
