package com.bitcamp.team_project_eco.user;

import com.bitcamp.team_project_eco.bookmark.Bookmark;
import com.bitcamp.team_project_eco.comment.Comment;
import com.bitcamp.team_project_eco.post.Post;
import com.bitcamp.team_project_eco.purchase.Purchase;
import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.bitcamp.team_project_eco.wishlist.Wishlist;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
@NamedQuery(name = "User.findByUserId",
            query = "select e from User e where e.userId = :userId")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq") private Long userSeq;
    @Column(name = "user_id") private String userId;
    @Column(name = "password") private String password;
    @Column(name = "register_date") private String registerDate;
    @Column(name = "addr") private String addr;
    @Column(name = "name") private String name;
    @Column(name = "sex") private String sex;
    @Column(name = "birth_date") private String birthDate;
    @Column(name = "email") private String email;
    @Column(name = "phone_number") private String phoneNumber;
    @Column(name = "visit_count") private int visitCount;
    @Column(name = "sns_confirm") private boolean snsConfirm;
    @Column(name = "email_confirm") private boolean emailConfirm;
    @Column(name = "grade") private int grade;
    @Column(name = "ban_date") private String banDate;
    @Column(name = "profile_image") private String profileImage;
    @Column(name = "profile_text") private String profileText;
    @Column(name = "payment_info") private String paymentInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsedCar> usedCarList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // 외래키를 주는 쪽이 oneToMany
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bookmark> bookmarkList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchase> purchasesList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wishlist> wishlistList = new ArrayList<>();


    public User() {}

    @Builder
    public User (String userId, String password, String registerDate, String addr,
                 String name, String sex, String birthDate, String email, String phoneNumber,
                 int visitCount, boolean snsConfirm, boolean emailConfirm, int grade,
                 String banDate, String profileImage, String profileText,
                 String paymentInfo) {
        this.userId = userId;
        this.password = password;
        this.registerDate = registerDate;
        this.addr = addr;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.visitCount = visitCount;
        this.snsConfirm = snsConfirm;
        this.emailConfirm = emailConfirm;
        this.grade = grade;
        this.banDate = banDate;
        this.profileImage = profileImage;
        this.profileText = profileText;
        this.paymentInfo = paymentInfo;

    }

}
