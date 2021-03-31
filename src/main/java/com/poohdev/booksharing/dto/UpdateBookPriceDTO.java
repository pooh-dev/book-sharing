package com.poohdev.booksharing.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateBookPriceDTO {
    @NotNull
    private Long id;
    @NotNull
    private Double price;
}
