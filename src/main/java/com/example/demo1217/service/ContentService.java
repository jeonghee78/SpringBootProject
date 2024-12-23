package com.example.demo1217.service;


import com.example.demo1217.dto.SaveDTO;
import com.example.demo1217.entity.ContentEntity;
import com.example.demo1217.repositrory.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ContentService {

    private ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {

        this.contentRepository = contentRepository;
    }


    public void saveContent(SaveDTO saveDTO) {

        String title = saveDTO.getTitle();
        String content = saveDTO.getContent();

        ContentEntity content1 = new ContentEntity();

        content1.setTitle(title);
        content1.setContent(content);


        contentRepository.save(content1);

        return;
    }

    public List<ContentEntity> selectContent() {

        return contentRepository.findAll();
    }

    public ContentEntity selectOneContent(String id) {

        int to = Integer.parseInt(id);

        return contentRepository.findById(to);
    }

    public void deleteOneContent(String id) {

        int to = Integer.parseInt(id);

        contentRepository.deleteById(to);
    }

    public void updateOneContent(SaveDTO saveDTO, String id) {

        int to = Integer.parseInt(id);

        ContentEntity content1 = new ContentEntity();
        content1.setId(to);
        content1.setTitle(saveDTO.getTitle());
        content1.setContent(saveDTO.getContent());

        contentRepository.save(content1);
    }
}
