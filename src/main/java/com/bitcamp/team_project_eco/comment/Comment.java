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

}
