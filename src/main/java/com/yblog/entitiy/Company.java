package com.yblog.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue
    @Column(name="COMPANY_ID")
    private Long id;

    private String name;
    private String about;
    private String url;
    private String imgAddress;
    private int reviewScore;
    private int realtimeScore;

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
