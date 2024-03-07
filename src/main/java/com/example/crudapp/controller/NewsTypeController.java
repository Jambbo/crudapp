package com.example.crudapp.controller;

import com.example.crudapp.domain.NewsType;
import com.example.crudapp.service.NewsService;
import com.example.crudapp.service.NewsTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/newsType")
@RequiredArgsConstructor
public class NewsTypeController {

    private final NewsTypeService newsTypeService;

    @PostMapping("/")
    public ResponseEntity<NewsType> createNewsType(@RequestBody NewsType newsType){
        NewsType createdNewsType = newsTypeService.createNewType(newsType);
        return new ResponseEntity<>(createdNewsType, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<NewsType>> getAllNewsTypes(){
        List<NewsType>newsTypes = newsTypeService.getAllNewsTypes();
        return new ResponseEntity<>(newsTypes,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NewsType> getNewsTypeById(@PathVariable Long id){
        NewsType newsType = newsTypeService.getNewsTypeById(id);
        return new ResponseEntity<>(newsType,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<NewsType>updateNewsType(@PathVariable Long id, @RequestBody NewsType newsTypeDetails){
        NewsType updatedNewsType = newsTypeService.updateNewsType(id,newsTypeDetails);
        return new ResponseEntity<>(updatedNewsType,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteNewsType(@PathVariable Long id){
        newsTypeService.deleteNewsType(id);
        return ResponseEntity.ok().build();
    }

}
