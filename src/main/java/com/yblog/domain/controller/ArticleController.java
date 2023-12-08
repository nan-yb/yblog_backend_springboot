package com.yblog.domain.controller;

import com.yblog.domain.service.IArticleService;
import com.yblog.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final IArticleService service;

    public List<Article> getListArticle(){
        return service.getArticleList();
    }

}
