package ru.otus.SpringMvcHomework.service;

import org.springframework.stereotype.Service;
import ru.otus.SpringMvcHomework.domain.Book;

@Service
public interface UserService {
    public Book add(Book book);
}
