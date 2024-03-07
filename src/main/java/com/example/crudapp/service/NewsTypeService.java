package com.example.crudapp.service;

import com.example.crudapp.domain.NewsType;

import java.util.List;

public interface NewsTypeService {

    NewsType createNewType(NewsType newsType);

    List<NewsType> getAllNewsTypes();

    NewsType getNewsTypeById(Long id);

    NewsType updateNewsType(Long id, NewsType newsTypeDetails);

    void deleteNewsType(Long id);

}
