package com.yblog.domain.controller;

import com.yblog.domain.service.IArticleService;
import com.yblog.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/article")
public class ArticleController {

    private final IArticleService service;


    @RequestMapping(value = "" , method = RequestMethod.GET)
    public List<Article> getListRecentArticle(){
        return service.getListRecentArticle();
    }



}
