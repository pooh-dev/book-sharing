package com.poohdev.booksharing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BookDTO {
    private Long id;
    private String isbn;
    private String name;
    private String language;
    private String description;
    private Integer numberOfPages;
    private Double price;
    private Set<Long> authorIds;
}
