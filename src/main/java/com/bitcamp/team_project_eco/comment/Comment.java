package com.bitcamp.team_project_eco.comment;

import com.bitcamp.team_project_eco.post.Post;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "comment")
@NamedQuery(name = "Comment.findByCommentId",
        query = "select e from Comment e where e.commentId = :comment_id")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id") private Long commentId;
    @Column(name = "reg_date", nullable = false, length = 45) private String regDate;
    @Column(name = "comment", nullable = false, length = 500) private String comment;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_seq")
    private User user;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {}

    public Comment(String regDate, String comment, User user, Post post) {
        this.regDate = regDate;
        this.comment = comment;
        setUser(user);
        setPost(post);
    }

}
