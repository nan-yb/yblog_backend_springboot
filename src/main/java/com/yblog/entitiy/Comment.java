package com.yblog.entitiy;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue
    @Column(name="COMMENT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
