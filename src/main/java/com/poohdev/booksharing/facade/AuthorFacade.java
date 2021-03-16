package com.poohdev.booksharing.facade;

import com.poohdev.booksharing.dto.AuthorDTO;
import com.poohdev.booksharing.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorFacade {
    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    public AuthorFacade(AuthorService authorService, ModelMapper modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorService.findAllAuthors().stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }
}
