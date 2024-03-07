package com.example.crudapp.repository;

import com.example.crudapp.domain.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsTypeRepository extends JpaRepository<NewsType,Long> {
}
