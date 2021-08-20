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
public class BooksController {

    private final BookDao bookDao;

    @Autowired
    public BooksController( BookDao bookDao){
        this.bookDao=bookDao;
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
//
//    @GetMapping("/getByName")
//    public String getByName(@RequestParam("name") String bookName, Model model) {
//        model.addAttribute("booksByName", bookDao.getByName(bookName));
//        return "books/getByName";
//    }
//
//    @GetMapping("/getByGenre")
//    public String getByGenre(@RequestParam("genre") String genre, Model model) {
//        model.addAttribute("booksByGenre", bookDao.getByGenreName(genre));
//        return "books/getByGenre";
//    }
//
//    @GetMapping("/getByAuthor")
//    public String getByAuthor(@RequestParam("author") String author, Model model) {
//        model.addAttribute("booksByAuthor", bookDao.getByAuthorName(author));
//        return "books/getByAuthor";
//    }
//
//
//    @GetMapping("/newBook")
//    public String newBook(Model model) {
//        model.addAttribute("book", new Book());
//        model.addAttribute("authors", authorDao.findAll());
//        model.addAttribute("genres", genreDao.findAll());
//        return "books/new";
//    }
//
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

