package com.bitcamp.team_project_eco.board;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter @Setter @ToString @NoArgsConstructor
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id") private Long id;
    @Column(name = "title", nullable = false) private String titie;
    @Column(name = "content", nullable = false) private String content;
    @Column(name = "hash_tag", nullable = false) private String hashTag;
    @CreationTimestamp
    @Column(name = "create_date") private LocalDateTime createDate;
    @CreationTimestamp
    @Column(name = "update_date") private LocalDateTime updateDate;
    @Column(name = "recomendation", nullable = false) private int recomendation;
    @Column(name = "board_hits", nullable = false) private Long boardHits;
    @Column(name = "user_id", nullable = false) private String userId;
    @Column(name = "community_id", nullable = false) private int communityId;
}
