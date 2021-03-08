package com.poohdev.booksharing.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String name;
    private String language;
    private String description;
    private Integer numberOfPages;
    private Double price;
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;
}
