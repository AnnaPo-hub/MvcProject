package ru.otus.SpringMvcHomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
//    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
//    @Autowired
//    BookDao bookDao;
//    @Autowired
//    GenreDao genreDao;
//    @Autowired
//    AuthorDao authorDao;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

//    @PostConstruct
//    public void init() {
//        Author author = new Author((long) 1, "Blok");
//        Author author2 = new Author((long) 2, "Proust");
//        authorDao.save(author);
//        authorDao.save(author2);
//        Genre genre = new Genre((long) 1, "Poetry");
//        Genre genre2 = new Genre((long) 2, "Fiction");
//        genreDao.save(genre);
//        genreDao.save(genre2);
//        bookDao.save(new Book((long) 1, "The sun", author, genre, null));
//        bookDao.save(new Book((long) 2, "The wind", author, genre, null));
//    }
}
