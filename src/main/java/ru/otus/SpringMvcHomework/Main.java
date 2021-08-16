package ru.otus.SpringMvcHomework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.SpringMvcHomework.dao.AuthorDao;
import ru.otus.SpringMvcHomework.dao.BookDao;
import ru.otus.SpringMvcHomework.dao.GenreDao;
import ru.otus.SpringMvcHomework.domain.Author;
import ru.otus.SpringMvcHomework.domain.Book;
import ru.otus.SpringMvcHomework.domain.Genre;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class Main {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    BookDao bookDao;
    @Autowired
    GenreDao genreDao;
    @Autowired
    AuthorDao authorDao;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @PostConstruct
    public void init() {
        Author author = new Author((long) 1, "Blok");
        authorDao.save(author);
        Genre genre = new Genre((long) 1, "Poetry");
        genreDao.save(genre);
        bookDao.save(new Book((long) 1, "The sun", author, genre, null));
        bookDao.save(new Book((long) 2, "The wind", author, genre, null));
    }
}
