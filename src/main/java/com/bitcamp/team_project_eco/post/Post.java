package com.bitcamp.team_project_eco.post;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id") private int postId;
    @Column(name = "link", nullable = false) private String link;
    @Column(name = "title", nullable = false) private String titie;
    @Column(name = "date") private String date;
    @Column(name = "img", nullable = false, length = 700) private String img;
    @Column(name = "content", nullable = false) private String content;
    @Column(name = "recomendation", nullable = false) private int recomendation;
    @Column(name = "hits", nullable = false) private int hits;

    public Post(){}

    @Builder
    public Post(int i, String s, String s1, String s2, String s3, String s4, int i1, int i2) {
        this.postId = i;
        this.link = s;
        this.titie = s1;
        this.date = s2;
        this.img = s3;
        this.content = s4;
        this.recomendation = i1;
        this.hits = i2;
    }
}
