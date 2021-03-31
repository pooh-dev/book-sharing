package com.poohdev.booksharing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AuthorDTO {
    private Long id;
    private String fullName;
    private String about;
    private Set<Long> bookIds;
}