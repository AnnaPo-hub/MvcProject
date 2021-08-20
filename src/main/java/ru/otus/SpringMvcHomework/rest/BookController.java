package ru.otus.SpringMvcHomework.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.SpringMvcHomework.dao.BookDao;
import ru.otus.SpringMvcHomework.domain.Author;
import ru.otus.SpringMvcHomework.domain.Book;
import ru.otus.SpringMvcHomework.domain.Genre;
import ru.otus.SpringMvcHomework.rest.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private final BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/api/book")
    public List<BookDto> getAllBooks() {
        return bookDao.findAll().stream().map(BookDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/book/{id}")
    public BookDto getById(@PathVariable Long id) {
        return BookDto.toDto(bookDao.getById(id));
    }

    @PostMapping("/api/book")
    public BookDto add(@RequestParam("name") String name,
                       @RequestParam("author") String author,
                       @RequestParam("genre") String genre) {
        final Book savedBook = bookDao.save(new Book(null, name, new Author(null, author), new Genre(null, genre), null));
        return BookDto.toDto(savedBook);
    }

    @DeleteMapping("/api/book/{id}")
    public void delete(@PathVariable long id) {
        bookDao.deleteById(id);
    }
}

