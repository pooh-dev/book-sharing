package com.poohdev.booksharing.repository;

import com.poohdev.booksharing.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByIsbn(String isbn);
    List<Book> findByNameContains(String name);
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);
}
