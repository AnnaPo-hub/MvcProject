package ru.otus.SpringMvcHomework.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.SpringMvcHomework.controllers.BooksController;
import ru.otus.SpringMvcHomework.domain.Author;
import ru.otus.SpringMvcHomework.domain.Book;
import ru.otus.SpringMvcHomework.domain.Genre;
import ru.otus.SpringMvcHomework.service.BookService;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BooksController.class)
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @BeforeEach
    void init() {
        Author author = new Author((long) 1, "Blok");
        Genre genre = new Genre((long) 1, "Poetry");
        Book book = new Book((long) 1, "The sun", author, genre, null);
        Mockito.when(bookService.showAllBooks()).thenReturn(List.of(book));
    }

    @WithMockUser(
            username = "admin",
            password = "adminPass",
            roles = "ADMIN"
    )

    @Test
    public void testAuthenticatedOnAdmin() throws Exception {

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk());
    }

    @WithMockUser(
            username = "user",
            password = "userPa",
            roles = "USER"
    )

    @Test
    public void testAuthenticatedOnUserGettingBookByAuthor() throws Exception {
        mockMvc.perform(get("/getByAuthor"))
                .andExpect(status().is4xxClientError());
    }

    @WithMockUser(
            username = "user",
            password = "userPa",
            roles = "USER"
    )

    @Test
    public void testAuthenticatedOnUserGettingBookByGenre() throws Exception {
        mockMvc.perform(get("/getByGenre"))
                .andExpect(status().is4xxClientError());
    }
}
