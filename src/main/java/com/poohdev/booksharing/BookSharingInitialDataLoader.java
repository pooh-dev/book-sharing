package com.poohdev.booksharing;

import com.poohdev.booksharing.domain.Author;
import com.poohdev.booksharing.domain.Book;
import com.poohdev.booksharing.repository.AuthorRepository;
import com.poohdev.booksharing.repository.BookRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;

@Component
public class BookSharingInitialDataLoader implements ApplicationRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookSharingInitialDataLoader(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(ApplicationArguments args) {

        if (isInitialDataExist()) {
            return;
        }

        Book book_1 = createBook("1234567890", "Book One", "About Book One", 110, 10D);
        Book book_2 = createBook("2345678901", "Book Two", "About Book Two", 220, 20D);
        Book book_3 = createBook("3456789012", "Book Three", "About Book Three", 330, 30D);
        Book book_4 = createBook("4567890123", "Book Four", "About Book Four", 440, 40D);
        Book book_5 = createBook("5678901234", "Book Five", "About Book Five", 550, 50D);
        bookRepository.saveAll(Arrays.asList(book_1, book_2, book_3, book_4, book_5));

        authorRepository.saveAll(Arrays.asList(
                createAuthor("Author One", "About Author One", book_1, book_4, book_5),
                createAuthor("Author Two", "About Author Two", book_2, book_4, book_5),
                createAuthor("Author Three", "About Author Three", book_3, book_5)));
    }

    private boolean isInitialDataExist() {
        Collection<Author> authors = (Collection<Author>) authorRepository.findAll();
        Collection<Book> books = (Collection<Book>) bookRepository.findAll();
        return !CollectionUtils.isEmpty(authors) && !CollectionUtils.isEmpty(books);
    }

    private Author createAuthor(String name, String about, Book ... books) {
        Author author = new Author();
        author.setFullName(name);
        author.setAbout(about);
        author.getBooks().addAll(Arrays.asList(books));
        return author;
    }

    private Book createBook(String isbn, String name, String description, Integer pages, Double price) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setName(name);
        book.setDescription(description);
        book.setNumberOfPages(pages);
        book.setPrice(price);
        return book;
    }
}
