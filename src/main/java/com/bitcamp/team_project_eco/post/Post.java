package com.bitcamp.team_project_eco.post;

import com.bitcamp.team_project_eco.comment.Comment;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;
    @Column(name = "link", nullable = false)
    private String link;
    @Column(name = "title", nullable = false)
    private String titie;
    @Column(name = "date")
    private String date;
    @Column(name = "img", nullable = false, length = 700)
    private String img;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "recomendation", nullable = false)
    private int recomendation;
    @Column(name = "hits", nullable = false)
    private int hits;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq") // 외래키를 받는 쪽.
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
