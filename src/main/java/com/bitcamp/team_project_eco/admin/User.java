package com.bitcamp.team_project_eco.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    private int userSeq;
    private String userId, registerDate, addr, name, ssr, email, phoneNumber, visitCount, nickname, snsConfirm,
                   emailConfirm, grade, ban_date, profileImage, profileText, admin_check, paymentInfo;
}
