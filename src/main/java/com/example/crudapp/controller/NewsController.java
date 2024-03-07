package com.example.crudapp.controller;

import com.example.crudapp.domain.News;
import com.example.crudapp.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @PostMapping("/")
    public ResponseEntity<News> createNews(@RequestBody News news){
        News createdNews = newsService.createNews(news);
        return new ResponseEntity<>(createdNews, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<News>>getAllNews(){
        List<News> news = newsService.getAllNews();
        return new ResponseEntity<>(news,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<News>getNewsById(@PathVariable Long id){
        News news = newsService.getNewsById(id);
        return new ResponseEntity<>(news,HttpStatus.OK);
    }
    @GetMapping("/type/{typeName}")
    public ResponseEntity<List<News>> getNewsByType(@PathVariable String typeName){
        List<News> news = newsService.getNewsByType(typeName);
        return new ResponseEntity<>(news,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News>updateNews(@PathVariable Long id,@RequestBody News newsDetails){
        News updatedNews = newsService.updateNews(id, newsDetails);
        return new ResponseEntity<>(updatedNews,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteNews(@PathVariable Long id){
        newsService.deleteNews(id);
        return ResponseEntity.ok().build();
    }
}
