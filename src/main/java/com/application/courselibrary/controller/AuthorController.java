package com.application.courselibrary.controller;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.repository.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String findAllAuthors(Model model) {
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/remove-author/{id}")
    public String deleteAuthor(@PathVariable Long id, Model model) {
        authorService.deleteAuthor(id);
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Model model){
        Author author = authorService.findAuthorById(id);
        model.addAttribute("author", author);
        return "update-author";
    }

    @PostMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Author author, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-author";
        }
        else{
            authorService.updateAuthor(author);
            model.addAttribute("authors", authorService.findAllAuthors());
            return "redirect:/authors";
        }
    }

    @GetMapping("/add-author")
    public String showCreateAuthor(Author author){
        return "add-author";
    }

    @PostMapping("/save-author")
    public String saveAuthor(Author author, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-author";
        }
        else{
            authorService.updateAuthor(author);
            model.addAttribute("authors", authorService.findAllAuthors());
            return "redirect:/authors";
        }
    }
}
