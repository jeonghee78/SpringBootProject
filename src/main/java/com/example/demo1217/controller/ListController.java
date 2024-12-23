package com.example.demo1217.controller;


import com.example.demo1217.repositrory.ContentRepository;
import com.example.demo1217.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ListController {



    private final ContentService contentService;

    public ListController(ContentRepository contentRepository, ContentService contentService) {

        this.contentService = contentService;
    }

    @GetMapping("/list")
    public String listPage(Model model) {
        
        model.addAttribute("ContentList", contentService.selectContent());

        return "list";
    }
}
