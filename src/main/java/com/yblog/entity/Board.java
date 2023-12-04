package com.yblog.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    private String slug;

    private LocalDateTime createAt;

    @PrePersist // insert시 동작 / 비영속 -> 영속
    public void onCreate(){
        this.createAt = LocalDateTime.now();
    }
}
