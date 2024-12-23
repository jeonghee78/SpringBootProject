package com.example.demo1217.repositrory;

import com.example.demo1217.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {

    ContentEntity findById(int id);

}

