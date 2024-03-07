package com.example.crudapp.service.impl;

import com.example.crudapp.domain.NewsType;
import com.example.crudapp.repository.NewsTypeRepository;
import com.example.crudapp.service.NewsTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsTypeServiceImpl implements NewsTypeService {
    private final NewsTypeRepository newsTypeRepository;
    @Override
    public NewsType createNewType(NewsType newsType) {
        return newsTypeRepository.save(newsType);
    }

    @Override
    public List<NewsType> getAllNewsTypes() {
        return newsTypeRepository.findAll();
    }

    @Override
    public NewsType getNewsTypeById(Long id) {
        return newsTypeRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("NewsType not found by id:"+id)
        );
    }


    @Override
    public NewsType updateNewsType(Long id, NewsType newsTypeDetails) {
        NewsType newsType = newsTypeRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("NewsType not found by id:"+id)
        );
        newsType.setTypeName(newsType.getTypeName());
        newsType.setColor(newsType.getColor());
        return newsType;
    }

    @Override
    public void deleteNewsType(Long id) {
        NewsType newsType = newsTypeRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("NewsType not found by id:"+id)
        );
        newsTypeRepository.delete(newsType);
    }
}
