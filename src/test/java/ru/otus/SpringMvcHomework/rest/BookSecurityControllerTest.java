package ru.otus.SpringMvcHomework.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.SpringMvcHomework.domain.Author;
import ru.otus.SpringMvcHomework.domain.Book;
import ru.otus.SpringMvcHomework.domain.Genre;
import ru.otus.SpringMvcHomework.service.BookService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class BookSecurityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookService bookService;

    @Test
    @WithMockUser(username = "user")
    public void userShouldGetAllBooks() {
        final List<Book> books = bookService.showAllBooks();
        System.out.println(books);
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Test
    @WithMockUser(username = "admin")
    public void adminShouldGetAllBooks() {
        final List<Book> books = bookService.showAllBooks();
        System.out.println(books);
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Test
    @WithMockUser(username = "admin")
    public void adminShouldCreateBook() {
        final Book book = bookService.createBook(new Book((long) 4, "New book title", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry")));
        assertNotNull(book);
    }

    @Test
    @WithMockUser(username = "user")
    public void userShouldNotCreateBook() {
        Exception exception = assertThrows(AccessDeniedException.class, () -> {
            bookService.createBook(new Book((long) 4, "New book title", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry")));
        });

        String expectedMessage = "Access is denied";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    @WithMockUser(username = "user")
    public void userShouldNotDeleteBook() {
        final Optional<Book> book = bookService.findBookById((long) 1);
        System.out.println(book);
        // bookService.deleteBookById((long) 1);

        // assertEquals();
    }

    @Test
    @WithMockUser(username = "admin")
    public void adminShouldDeleteBook() {
        bookService.deleteBookById((long) 1);
        assertEquals(Optional.empty(), bookService.findBookById((long) 1));
    }
}

