package ru.otus.SpringMvcHomework.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import ru.otus.SpringMvcHomework.domain.Book;

import java.util.List;

@Component
public interface BookDao extends JpaRepository<Book, Long> {
    List<Book> getByName(String bookName);

    List<Book> getByGenreName(String genre);

    List<Book> getByAuthorName(String authorName);

    @PostFilter("hasPermission(filterObject, 'READ')")
    List<Book> findAll();

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    Book getById(Long id);

    @SuppressWarnings("unchecked")
    @PreAuthorize("hasPermission(#noticeMessage, 'WRITE')")
    Book save(@Param("book") Book book);
}

