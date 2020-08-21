package com.bitcamp.team_project_eco.post;

import com.bitcamp.team_project_eco.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NewPostVO {
    String postId, userName, link, title, date, img, content, category, userSeq;
}
