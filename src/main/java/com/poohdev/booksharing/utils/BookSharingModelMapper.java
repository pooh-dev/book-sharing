package com.poohdev.booksharing.utils;

import com.poohdev.booksharing.converter.AuthorDtoConverter;
import com.poohdev.booksharing.converter.AuthorModelConverter;
import com.poohdev.booksharing.converter.BookDtoConverter;
import com.poohdev.booksharing.converter.BookModelConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookSharingModelMapper {

    private final ModelMapper modelMapper;

    public BookSharingModelMapper(AuthorModelConverter authorModelConverter,
                                  AuthorDtoConverter authorDtoConverter,
                                  BookModelConverter bookModelConverter,
                                  BookDtoConverter bookDtoConverter) {

        modelMapper = new ModelMapper();
        modelMapper.addConverter(authorModelConverter);
        modelMapper.addConverter(authorDtoConverter);
        modelMapper.addConverter(bookModelConverter);
        modelMapper.addConverter(bookDtoConverter);
    }

    public <D> D map(Object source, Class<D> destination) {
        return modelMapper.map(source, destination);
    }
}
