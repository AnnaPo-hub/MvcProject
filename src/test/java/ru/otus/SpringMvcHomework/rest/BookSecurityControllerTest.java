package ru.otus.SpringMvcHomework.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.SpringMvcHomework.domain.Book;
import ru.otus.SpringMvcHomework.service.BookService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
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
    public void userShouldGetOneBook() {
        final List<Book> books = bookService.showAllBooks();
        System.out.println(books);
        assertNotNull(books);
        assertEquals(3, books.size());
    }
}

