package com.bitcamp.team_project_eco.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Board {
    @Id
    private int boardNo;
    private String titie, writer, date, like;
}
