package com.poohdev.booksharing.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NewAuthorDTO {
    @NotNull
    private String fullName;
    @NotNull
    private String about;
}
