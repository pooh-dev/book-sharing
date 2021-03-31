package com.poohdev.booksharing.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NewBookDTO {
    @NotNull
    private String isbn;
    @NotNull
    private String name;
    private String language;
    @NotNull
    private String description;
    @NotNull
    private Integer numberOfPages;
    @NotNull
    private Double price;
}
