package com.example.crudapp.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "news")
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortDescription;
    private String fullDescription;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private NewsType type;
}
