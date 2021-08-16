package ru.otus.SpringMvcHomework.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.SpringMvcHomework.domain.Author;

import java.util.List;

@Component
public interface AuthorDao extends JpaRepository<Author, Long> {
    List<Author> getByName(String authorName);
}
