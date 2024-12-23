package com.example.demo1217.controller;


import com.example.demo1217.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContentController {

    private ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {

        this.contentService = contentService;
    }


    @GetMapping("/content/{id}")
    public String contentPage(@PathVariable("id")String id, Model model) {

        System.out.println(id);

        contentService.selectOneContent(id);

        model.addAttribute("Content", contentService.selectOneContent(id));

        return "content";
    }
}
