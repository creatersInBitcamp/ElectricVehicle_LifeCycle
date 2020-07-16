package com.bitcamp.team_project_eco.board;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id") private Long id;
    private String titie;
    private String content;
    private String hashTag;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int recomendation;
    private Long boardHits;
    private String userId;
    private int communityNo;
}