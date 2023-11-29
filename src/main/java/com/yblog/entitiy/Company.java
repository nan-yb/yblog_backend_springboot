package com.yblog.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

}
