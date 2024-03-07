package com.example.crudapp.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "news_type")
@Data
public class NewsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    private String color;

}
