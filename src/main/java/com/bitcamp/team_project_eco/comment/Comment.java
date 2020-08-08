package com.bitcamp.team_project_eco.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id") private int commentId;
    @Column(name = "post_id", nullable = false) private int postId;
    @Column(name = "user_seq", nullable = false) private int userSeq;
    @CreationTimestamp
    @Column(name = "reg_date", nullable = false, length = 45) private LocalDate regDate;
    @Column(name = "comment", nullable = false, length = 500) private String comment;

    public Comment() {}

    @Builder
    public Comment(int commentId, int postId, int userSeq, LocalDate regDate, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.userSeq = userSeq;
        this.regDate = regDate;
        this.comment = comment;
    }
}
