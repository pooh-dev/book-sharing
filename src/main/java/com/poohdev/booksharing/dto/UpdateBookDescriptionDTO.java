package com.poohdev.booksharing.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateBookDescriptionDTO {
    @NotNull
    private Long id;
    @NotNull
    private String description;
}
