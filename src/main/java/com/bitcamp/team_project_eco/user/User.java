package com.bitcamp.team_project_eco.user;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq") private Long userSeq;
    @Column(name = "user_id") private String userId;
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

    @Builder
    private User(
        Long userSeq,
        String userId,
        String password,
        String registerDate,
        String addr,
        String name,
        String ssr,
        String email,
        String phoneNumber,
        String visitCount,
        String snsConfirm,
        String emailConfirm,
        String grade,
        String banDate,
        String profileImage,
        String profileText,
        String adminCheck,
        String paymentInfo){
        this.userSeq = userSeq;
        this.userId = userId;
        this.password = password;
        this.registerDate = registerDate;
        this.addr = addr;
        this.name = name;
        this.ssr = ssr;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.visitCount = visitCount;
        this.snsConfirm = snsConfirm;
        this.emailConfirm = emailConfirm;
        this.grade = grade;
        this.banDate = banDate;
        this.profileImage = profileImage;
        this.profileText = profileText;
        this.adminCheck = adminCheck;
        this.paymentInfo = paymentInfo;

    }
}
