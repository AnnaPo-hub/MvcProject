package ru.otus.SpringMvcHomework.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringMvcHomework.dao.AuthorDao;
import ru.otus.SpringMvcHomework.domain.Author;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    @Transactional
    @Override
    public Author insert(Author author) {
        return authorDao.save(author);
    }


    @Override
    public List<Author> getAll() {
        return authorDao.findAll();
    }


    @Override
    public List<Author> getByName(String authorName) {
        return authorDao.getByName(authorName);
    }


    @Override
    public Optional<Author> getById(Long id) {
        return authorDao.findById(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        authorDao.deleteById(id);
    }
}
