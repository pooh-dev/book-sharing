package com.poohdev.booksharing;

import com.poohdev.booksharing.converter.AuthorConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookSharingConfiguration {

    @Bean
    public ModelMapper modelMapper(AuthorConverter authorConverter) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(authorConverter);
        return modelMapper;
    }

}
