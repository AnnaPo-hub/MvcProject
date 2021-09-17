package ru.otus.SpringMvcHomework.service;

import org.springframework.stereotype.Service;
import ru.otus.SpringMvcHomework.domain.Author;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {
    Author insert(Author author);

    List<Author> getAll();

    List<Author> getByName(String authorName);

    Optional<Author> getById(Long id);

    void deleteById(Long id);
}
