package com.bitcamp.team_project_eco.board;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20) private Long boardNo;
    @Column(length = 50) private String titie;
    @Column private String content;
    @Column(length = 20) private String hashTag;
    @Column(length = 20) private LocalDateTime createDate;
    @Column(length = 20) private LocalDateTime updateDate;
    @Column(length = 20) private int recomendation;
    @Column(length = 20) private Long boardHits;
    @Column(length = 20) private String userId;
    @Column(length = 20) private int communityNo;
}