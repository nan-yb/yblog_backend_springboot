package com.yblog.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String email;
    private String password;
    private String authYn;

    @ManyToOne
    @JoinColumn(name="COMPANY_ID")
    private Company company;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

}
