package com.example.mvc_crud.controller;

import com.example.mvc_crud.controller.repository.ArticleRepository;
import com.example.mvc_crud.dto.ArticleForm;
import com.example.mvc_crud.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String ArticleNew(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String ArticleCreate(ArticleForm form){
        Article article = form.toEntity();
        articleRepository.save(article);
        return "redirect:/articles/" + article.getId();
    }

    @GetMapping("/articles/{id}")
    public String ArticleOne(@PathVariable Long id, Model model){
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article",article);
        return "articles/show";
    }

    @GetMapping("/articles")
    public String ArticleAll(Model model){
        List<Article> articles = (List<Article>) articleRepository.findAll();
        model.addAttribute("articles",articles);
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String ArticleEdit(@PathVariable Long id,Model model){
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article",article);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String ArticleUpdate(ArticleForm form){
        Article article = form.toEntity();
        if(article != null) {
            articleRepository.save(article);
        }
        return "redirect:/articles/" + article.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String ArticleDelete(@PathVariable Long id){
        Article article = articleRepository.findById(id).orElse(null);
        if(article != null){
            articleRepository.delete(article);
        }
        return "redirect:/articles/";
    }

}
