package ru.otus.SpringMvcHomework.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookPagesController {
    @GetMapping("/")
    public String listPage(Model model) {
        model.addAttribute("keywords", "library books , list books, library free");
        return "books/list";
    }
}
