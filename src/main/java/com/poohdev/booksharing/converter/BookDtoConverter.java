package com.poohdev.booksharing.converter;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.dto.BookDTO;
import com.poohdev.booksharing.service.AuthorService;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookDtoConverter implements Converter<BookDTO, Book> {

    private final AuthorService authorService;

    public BookDtoConverter(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public Book convert(MappingContext<BookDTO, Book> context) {
        BookDTO bookDTO = context.getSource();

        Book book = new Book();
        if (bookDTO.getId() != null) {
            book.setId(bookDTO.getId());
        }
        book.setIsbn(bookDTO.getIsbn());
        book.setName(bookDTO.getName());
        book.setLanguage(bookDTO.getLanguage());
        book.setDescription(bookDTO.getDescription());
        book.setNumberOfPages(bookDTO.getNumberOfPages());
        book.setPrice(bookDTO.getPrice());

        if (CollectionUtils.isNotEmpty(bookDTO.getAuthorIds())) {
            Set<Author> authors = bookDTO.getAuthorIds().stream()
                    .map(authorService::findById)
                    .collect(Collectors.toSet());
            book.setAuthors(authors);
        }

        return book;
    }
}
