package com.yblog.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Article {

    @Id
    @GeneratedValue
    @Column(name = "ARTICLE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    private String thumbImageUrl;

    private int viewCount;
    private int thumbCount;
    private int commentCount;
    private int deleteTime;

    @OneToMany(mappedBy = "article")
    private List<Comment> commentList;


}
