package com.example.demo1217.controller;


import com.example.demo1217.dto.SaveDTO;
import com.example.demo1217.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaveController {


    private ContentService contentService;

    @Autowired
    public SaveController(ContentService contentService) {

        this.contentService = contentService;
    }


    @PostMapping("/save")
    public String saveLogic(SaveDTO saveDTO) {

        contentService.saveContent(saveDTO);


        return "redirect:/";
    }

    @PostMapping("/save/{id}")
    public String updateLogic(SaveDTO saveDTO, @PathVariable("id")String id) {

        contentService.updateOneContent(saveDTO, id);

        return "redirect:/content/" + id;
    }
}
