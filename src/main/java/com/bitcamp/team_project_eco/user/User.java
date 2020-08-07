package com.bitcamp.team_project_eco.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @ToString @NoArgsConstructor @Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false) private String userId;

    @Column(name = "password", nullable = false) private String password;

    @Column(name = "register_date" ) private LocalDateTime registerDate;

    @Column(name = "addr") private String addr;

    @Column(name = "name")private String name;

    @Column(name = "ssr") private String ssr;

    @Column(name = "email") private String email;

    @Column(name = "phone_number") private String phoneNumber;

    @Column(name = "visit_count") private Integer visitCount;

    @Column(name = "nickname") private String nickname;

    @Column(name = "sns_confirm") private String snsConfirm;

    @Column(name = "email_confirm") private String emailConfirm;

    @Column(name = "grade") private String grade;

    @Column(name = "ban_date") private LocalDateTime banDate;

    @Column(name = "profile_image") private String profileImage;

    @Column(name = "profile_text") private String profileText;

    @Column(name = "admin_check") private String adminCheck;

    @Column(name = "payment_info") private String paymentInfo;
}
