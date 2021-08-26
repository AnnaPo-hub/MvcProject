package ru.otus.SpringMvcHomework.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookPagesController {
    @GetMapping("/")
    public String listPage() {
        return "books/list";
    }
}
