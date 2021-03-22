package com.poohdev.booksharing.converter;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.dto.AuthorDTO;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AuthorModelConverter implements Converter<Author, AuthorDTO> {
    @Override
    public AuthorDTO convert(MappingContext<Author, AuthorDTO> context) {
        Author author = context.getSource();

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setFullName(author.getFullName());
        authorDTO.setAbout(author.getAbout());

        Set<Long> bookIds = author.getBooks().stream()
                .map(Book::getId)
                .collect(Collectors.toSet());
        authorDTO.setBookIds(bookIds);

        return authorDTO;
    }
}
