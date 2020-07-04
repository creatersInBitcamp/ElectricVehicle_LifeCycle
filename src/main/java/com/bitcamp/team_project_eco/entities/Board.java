package com.bitcamp.team_project_eco.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;
    private String titie, writer, date, like;
}
