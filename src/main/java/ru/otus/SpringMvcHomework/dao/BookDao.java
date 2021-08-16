package ru.otus.SpringMvcHomework.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.SpringMvcHomework.domain.Book;

import java.util.List;

@Component
public interface BookDao extends JpaRepository<Book, Long> {
    List<Book> getByName(String bookName);

    List<Book> getByGenreName(String genre);

    List<Book> getByAuthorName(String authorName);
}

