package com.example.crudapp.service.impl;

import com.example.crudapp.domain.News;
import com.example.crudapp.repository.NewsRepository;
import com.example.crudapp.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("News not found with id:"+id)
        );
    }

    @Override
    public List<News> getNewsByType(String typeName) {
        return newsRepository.findByTypeTypeName(typeName);
    }

    @Override
    public News updateNews(Long id, News newsDetails) {
        News news = newsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("News not found with id:"+id)
        );
        news.setShortDescription(newsDetails.getShortDescription());
        news.setFullDescription(newsDetails.getFullDescription());
        news.setType(newsDetails.getType());
        return newsRepository.save(news);
    }

    @Override
    public void deleteNews(Long id) {
        News news = newsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("News not found with id:"+id)
        );
        newsRepository.delete(news);
    }
}
