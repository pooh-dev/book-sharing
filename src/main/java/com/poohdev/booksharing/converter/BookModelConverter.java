package com.poohdev.booksharing.converter;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.dto.BookDTO;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookModelConverter implements Converter<Book, BookDTO> {
    @Override
    public BookDTO convert(MappingContext<Book, BookDTO> context) {
        Book book = context.getSource();

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setName(book.getName());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setNumberOfPages(book.getNumberOfPages());
        bookDTO.setPrice(book.getPrice());

        Set<Long> authorsIds = book.getAuthors().stream()
                .map(Author::getId)
                .collect(Collectors.toSet());
        bookDTO.setAuthorIds(authorsIds);

        return bookDTO;
    }
}
