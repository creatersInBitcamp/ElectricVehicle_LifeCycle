package com.bitcamp.team_project_eco.comment;

import com.bitcamp.team_project_eco.post.Post;
import com.bitcamp.team_project_eco.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString @NoArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id") private int commentId;
    @CreationTimestamp
    @Column(name = "reg_date", nullable = false, length = 45) private DateTime regDate;
    @Column(name = "comment", nullable = false, length = 500) private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
