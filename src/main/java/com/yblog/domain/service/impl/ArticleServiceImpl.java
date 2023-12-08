package com.yblog.domain.service.impl;

import com.yblog.domain.service.IArticleService;
import com.yblog.entity.Article;
import com.yblog.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements IArticleService {

    private final ArticleRepository repository;

    @Override
    public Article createArticle(Article article) {
        return repository.save(article);
    }

    @Override
    public Article updateArticle(Article article) {
        return null;
    }

    @Override
    public Article getArticle(long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Article> getArticleList() {
        return repository.findAll();
    }
}
