package com.bitcamp.team_project_eco.comment;

import com.bitcamp.team_project_eco.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id") private int commentId;
    @CreationTimestamp
    @Column(name = "reg_date", nullable = false, length = 45) private DateTime regDate;
    @Column(name = "comment", nullable = false, length = 500) private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Comment(int commentId, DateTime regDate, String comment, User user) {
        this.commentId = commentId;
        this.regDate = regDate;
        this.comment = comment;
        this.user = user;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public DateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(DateTime regDate) {
        this.regDate = regDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", regDate=" + regDate +
                ", comment='" + comment + '\'' +
                ", user=" + user +
                '}';
    }
}
