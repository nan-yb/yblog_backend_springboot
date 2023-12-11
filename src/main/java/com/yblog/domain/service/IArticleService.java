package com.yblog.domain.service;

import com.yblog.entity.Article;

import java.util.List;

public interface IArticleService {

    Article createArticle(Article article);
    Article updateArticle(Article article);
    Article getArticle(long id);
    List<Article> getArticleList();
    List<Article> getListRecentArticle();
}
