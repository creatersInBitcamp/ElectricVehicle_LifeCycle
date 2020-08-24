package com.bitcamp.team_project_eco.post;

import com.bitcamp.team_project_eco.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class NewPostVO {
    String postId, userId, link, title, date, img, content, category, userSeq;
}
