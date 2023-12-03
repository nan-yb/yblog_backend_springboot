package com.yblog.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String email;
    private String password;
    private String authCd;

    @ManyToOne
    @JoinColumn(name="COMPANY_ID")
    private Company company;

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
