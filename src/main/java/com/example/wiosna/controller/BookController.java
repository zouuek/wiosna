package com.example.wiosna.controller;

import com.example.wiosna.model.Book;
import com.example.wiosna.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/book")

public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Book book) {
        this.bookService.saveOrUpdate(book);
        return "redirect:/adminpanel";
    }
    @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        Optional<Book> bookOpt = this.bookService.getById(id);
        if(bookOpt.isEmpty()) {
            return "redirect:/adminpanel";
        }
        model.addAttribute("book", bookOpt.get());
        return "book-form";
    }
    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @ModelAttribute Book book) {
        //book.setId(id);
        this.bookService.saveOrUpdate(book);
        return "redirect:/adminpanel";
    }
    @PostMapping("/delete")
    public String deleteBook(@RequestParam int id) {
        bookService.delete(id);
        return "redirect:/adminpanel";
    }


}
