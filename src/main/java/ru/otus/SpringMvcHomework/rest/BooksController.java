package ru.otus.SpringMvcHomework.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.SpringMvcHomework.dao.BookDao;
import ru.otus.SpringMvcHomework.rest.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BooksController {

    private final BookDao bookDao;
   // private final AuthorDao authorDao;
   // private final GenreDao genreDao;

    @Autowired
    public BooksController( BookDao bookDao){
        this.bookDao=bookDao;
    }

    @GetMapping("/api/books")
    public List<BookDto> getAllBooks() {
        return bookDao.findAll().stream().map(BookDto::toDto)
                .collect(Collectors.toList());
    }






//    @GetMapping("/getById")
//    public String getById(@RequestParam("id") Long id, Model model) {
//        model.addAttribute("booksById", bookDao.getById(id));
//        return "books/getById";
//    }
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
//    @PostMapping()
//    public String create(@ModelAttribute("book") Book book) {
//        bookDao.save(book);
//        return "books/success";
//    }
//
//    @ResponseBody
//    @DeleteMapping("/delete")
//    public void delete(@RequestParam(name = "id") long id) {
//        bookDao.deleteById(id);
//    }
}

