package com.bitcamp.team_project_eco.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;
    private String titie;
    private String content;
    private String hashTag;
    private String createDate;
    private String updateDate;
    private Long recomendation;
    private Long boardHits;
    private String userId;
    private Long communityNo;
}