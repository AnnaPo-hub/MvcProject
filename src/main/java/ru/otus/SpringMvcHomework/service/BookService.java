package ru.otus.SpringMvcHomework.service;


import org.springframework.stereotype.Service;
import ru.otus.SpringMvcHomework.domain.Book;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    Book createBook(Book book);

    List<Book> showAllBooks();

    List<Book> findBookByName(String bookName);

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByGenre(String genre);

    Optional<Book> findBookById(Long id);

    void deleteBookById(Long id);
}
