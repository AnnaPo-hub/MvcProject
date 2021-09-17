package ru.otus.SpringMvcHomework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.SpringMvcHomework.dao.AuthorDao;
import ru.otus.SpringMvcHomework.dao.BookDao;
import ru.otus.SpringMvcHomework.dao.GenreDao;


@SpringBootApplication
public class Main {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private BookDao bookDao;
    @Autowired
    private GenreDao genreDao;
    @Autowired
    private AuthorDao authorDao;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

}
