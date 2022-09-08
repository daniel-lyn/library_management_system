package com.application.courselibrary.controller;


import com.application.courselibrary.entity.Category;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.repository.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model) {
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "publishers";
    }

    @GetMapping("/remove-publisher/{id}")
    public String deletePublisher(@PathVariable Long id, Model model) {
        publisherService.deletePublisher(id);
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "publishers";
    }

    @GetMapping("update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Model model){
        Publisher publisher = publisherService.findPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "update-publisher";
    }

    @PostMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-publisher";
        }
        else{
            publisherService.updatePublisher(publisher);
            model.addAttribute("publishers", publisherService.findAllPublishers());
            return "redirect:/publishers";
        }
    }

    @GetMapping("/add-publisher")
    public String showCreatePublisher(Publisher publisher){
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String savePublisher(Publisher publisher, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-publisher";
        }
        else{
            publisherService.updatePublisher(publisher);
            model.addAttribute("publishers", publisherService.findAllPublishers());
            return "redirect:/publishers";
        }
    }
}
