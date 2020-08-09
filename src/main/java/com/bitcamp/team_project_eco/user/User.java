package com.bitcamp.team_project_eco.user;

//import com.bitcamp.team_project_eco.post.Post;
import com.bitcamp.team_project_eco.comment.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq") private Long userSeq;
    @Column(name = "user_id") private String userId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password") private String password;
    @Column(name = "register_date") private String registerDate;
    @Column(name = "addr") private String addr;
    @Column(name = "name") private String name;
    @Column(name = "ssr") private String ssr;
    @Column(name = "email") private String email;
    @Column(name = "phone_number") private String phoneNumber;
    @Column(name = "visit_count") private String visitCount;
    @Column(name = "sns_confirm") private String snsConfirm;
    @Column(name = "email_confirm") private String emailConfirm;
    @Column(name = "grade") private String grade;
    @Column(name = "ban_date") private String banDate;
    @Column(name = "profile_image") private String profileImage;
    @Column(name = "profile_text") private String profileText;
    @Column(name = "admin_check") private String adminCheck;
    @Column(name = "payment_info") private String paymentInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // 외래키를 주는 쪽이 oneToMany
    private List<Post> postList;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
