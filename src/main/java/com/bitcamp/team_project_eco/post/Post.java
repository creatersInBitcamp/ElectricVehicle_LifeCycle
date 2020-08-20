package com.bitcamp.team_project_eco.post;

import com.bitcamp.team_project_eco.comment.Comment;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString(exclude = {"user","comments"})
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false) private Long postId;
    @Column(name = "user_name", nullable = false, length = 30) private String userId;
    @Column(name = "link", nullable = false) private String link;
    @Column(name = "title", nullable = false) private String title;
    @Column(name = "date") private String date;
    @Column(name = "img", nullable = false, length = 700) private String img;
    @Column(name = "content", nullable = false) private String content;
    @Column(name = "recomendation", nullable = false) private int recommendation;
    @Column(name = "", nullable = false) private int report;
    @Column(name = "hits", nullable = false) private int hits;
    @Column(name = "category", nullable = false, length = 45) private String category;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq") // 외래키를 받는 쪽.
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(value = FetchMode.SELECT)
    private List<Comment> comments = new ArrayList<>();

    public Post(String userId, String link, String title, String date, String img,
                String content, int recommendation, int report, int hits, String category, User user,
                List<Comment> commentList) {
        this.userId = userId;
        this.link = link;
        this.title = title;
        this.date = date;
        this.img = img;
        this.content = content;
        this.recommendation = recommendation;
        this.report = report;
        this.hits = hits;
        this.category = category;
        setUser(user);
        this.comments.addAll(commentList);
    }

    public Post() {

    }
}
