package ru.otus.SpringMvcHomework.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringMvcHomework.domain.Author;
import ru.otus.SpringMvcHomework.domain.Book;
import ru.otus.SpringMvcHomework.domain.Genre;
import ru.otus.SpringMvcHomework.service.BookService;
import ru.otus.SpringMvcHomework.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class BookSecurityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

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
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Test
    @Transactional
    @WithMockUser(authorities = {"ROLE_ADMIN"})
    public void adminShouldCreateBook() {
        final Book book = userService.add(new Book((long) 4, "New book title", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry")));
        assertNotNull(book);
        final List<Book> books = bookService.showAllBooks();
        assertNotNull(books);
        assertEquals(4, books.size());
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
        Exception exception = assertThrows(AccessDeniedException.class, () -> {
            bookService.deleteBookById((long) 3);
        });

        String expectedMessage = "Access is denied";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @WithMockUser(authorities = {"ROLE_ADMIN"})
    public void adminShouldDeleteBook() {
        bookService.createBook(new Book((long) 4, "New book title", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry")));
        bookService.deleteBookById((long) 4);
        assertEquals(Optional.empty(), bookService.findBookById((long) 4));
    }
}

