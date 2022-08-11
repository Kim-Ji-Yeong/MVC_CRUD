package com.example.mvc_crud.dto;

import com.example.mvc_crud.entity.Article;
import lombok.AllArgsConstructor;

import javax.naming.ContextNotEmptyException;
@AllArgsConstructor
public class ArticleForm {

    private Long id;

    private String title;

    private String content;

    public Article toEntity() {
        return new Article(id,title,content);
    }
}
