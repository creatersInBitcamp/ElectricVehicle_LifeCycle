package com.bitcamp.team_project_eco.user;

import com.bitcamp.team_project_eco.comment.Comment;
import com.bitcamp.team_project_eco.post.Post;
import com.bitcamp.team_project_eco.usedCar.UsedCar;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UsedCar> usedCarList;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // 외래키를 주는 쪽이 oneToMany
    private List<Post> postList;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public User(Long userSeq, String userId, String password, String registerDate, String addr, String name, String ssr, String email, String phoneNumber, String visitCount, String snsConfirm, String emailConfirm, String grade, String banDate, String profileImage, String profileText, String adminCheck, String paymentInfo, List<UsedCar> usedCarList, List<Post> postList, List<Comment> comments) {
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
        this.usedCarList = usedCarList;
        this.postList = postList;
        this.comments = comments;
    }

    public Long getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(Long userSeq) {
        this.userSeq = userSeq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsr() {
        return ssr;
    }

    public void setSsr(String ssr) {
        this.ssr = ssr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(String visitCount) {
        this.visitCount = visitCount;
    }

    public String getSnsConfirm() {
        return snsConfirm;
    }

    public void setSnsConfirm(String snsConfirm) {
        this.snsConfirm = snsConfirm;
    }

    public String getEmailConfirm() {
        return emailConfirm;
    }

    public void setEmailConfirm(String emailConfirm) {
        this.emailConfirm = emailConfirm;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getBanDate() {
        return banDate;
    }

    public void setBanDate(String banDate) {
        this.banDate = banDate;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileText() {
        return profileText;
    }

    public void setProfileText(String profileText) {
        this.profileText = profileText;
    }

    public String getAdminCheck() {
        return adminCheck;
    }

    public void setAdminCheck(String adminCheck) {
        this.adminCheck = adminCheck;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<UsedCar> getUsedCarList() {
        return usedCarList;
    }

    public void setUsedCarList(List<UsedCar> usedCarList) {
        this.usedCarList = usedCarList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "userSeq=" + userSeq +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", addr='" + addr + '\'' +
                ", name='" + name + '\'' +
                ", ssr='" + ssr + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", visitCount='" + visitCount + '\'' +
                ", snsConfirm='" + snsConfirm + '\'' +
                ", emailConfirm='" + emailConfirm + '\'' +
                ", grade='" + grade + '\'' +
                ", banDate='" + banDate + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", profileText='" + profileText + '\'' +
                ", adminCheck='" + adminCheck + '\'' +
                ", paymentInfo='" + paymentInfo + '\'' +
                ", usedCarList=" + usedCarList +
                ", postList=" + postList +
                ", comments=" + comments +
                '}';
    }
}
