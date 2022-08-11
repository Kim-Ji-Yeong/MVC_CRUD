package com.example.mvc_crud.controller.repository;

import com.example.mvc_crud.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
