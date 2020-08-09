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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq") // 외래키를 받는 쪽.
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Post(int postId, String link, String title, String date, String img, String content, int recomendation, int hits, int userSeq) {
        this.postId = postId;
        this.link = link;
        this.titie = title;
        this.date = date;
        this.img = img;
        this.content = content;
        this.recomendation = recomendation;
        this.hits = hits;
    }

    public Post() {

    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitie() {
        return titie;
    }

    public void setTitie(String titie) {
        this.titie = titie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(int recomendation) {
        this.recomendation = recomendation;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", link='" + link + '\'' +
                ", titie='" + titie + '\'' +
                ", date='" + date + '\'' +
                ", img='" + img + '\'' +
                ", content='" + content + '\'' +
                ", recomendation=" + recomendation +
                ", hits=" + hits +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
