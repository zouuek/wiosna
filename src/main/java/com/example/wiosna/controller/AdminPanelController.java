package com.example.wiosna.controller;

import com.example.wiosna.model.Book;
import com.example.wiosna.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {
    @Autowired
    private BookService bookService;
    @GetMapping("/adminpanel")
    public String adminpanel(Model model) {
        model.addAttribute("books", this.bookService.getAll());
        return "adminpanel";
    }

}
