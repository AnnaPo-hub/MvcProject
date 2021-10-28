package ru.otus.SpringMvcHomework.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.SpringMvcHomework.domain.Genre;

import java.util.List;

@Component
public interface GenreDao extends JpaRepository<Genre, Long> {
    List<Genre> getByName(String genreName);
}
