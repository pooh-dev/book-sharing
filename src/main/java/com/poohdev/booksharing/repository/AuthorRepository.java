package com.poohdev.booksharing.repository;

import com.poohdev.booksharing.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByFullNameContains(String name);
}
