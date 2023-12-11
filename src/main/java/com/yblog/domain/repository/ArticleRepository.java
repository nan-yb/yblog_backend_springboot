package com.yblog.domain.repository;

import com.yblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article , Long> {

//    select m from Member m where m.email = ?1
    @Query("select a from Article a order by a.id desc")
    public List<Article> getListRecentArticle();
}
