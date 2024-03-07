package com.example.crudapp.service;

import com.example.crudapp.domain.News;

import java.util.List;

public interface NewsService {

    News createNews(News news);

    List<News>getAllNews();

    News getNewsById(Long id);
    List<News> getNewsByType(String typeName);

    News updateNews(Long id, News newsDetails);

    void deleteNews(Long id);

}
