package com.yblog.entitiy;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    private String slug;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
}
