package com.bitcamp.team_project_eco.comment;

import com.bitcamp.team_project_eco.post.Post;
import com.bitcamp.team_project_eco.user.User;
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
    @Column(name = "reg_date", nullable = false, length = 45) private DateTime regDate;
    @Column(name = "comment", nullable = false, length = 500) private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() { }

}
