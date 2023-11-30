package com.yblog.entitiy;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
    @PrePersist // insert시 동작 / 비영속 -> 영속
    public void onCreate(){
        this.createAt = LocalDateTime.now();
    }
    @PreUpdate // insert시 동작 / 비영속 -> 영속
    public void onUpdate(){
        this.updateAt = LocalDateTime.now();
    }
}
