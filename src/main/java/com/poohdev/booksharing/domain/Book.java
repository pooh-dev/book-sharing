package com.poohdev.booksharing.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@ToString
@EqualsAndHashCode(of = "id")
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String isbn;

    private String name;

    private String language;

    private String description;

    private Integer numberOfPages;

    private Double price;

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();
}
