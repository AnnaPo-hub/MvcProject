package ru.otus.SpringMvcHomework.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.SpringMvcHomework.domain.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private String author;
    private String genre;
    //private List<Comment> comment;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getName(), book.getAuthor().getName(), book.getGenre().getName());
    }

}
