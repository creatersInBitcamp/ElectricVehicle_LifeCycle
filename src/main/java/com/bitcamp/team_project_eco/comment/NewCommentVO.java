package com.bitcamp.team_project_eco.comment;

import com.bitcamp.team_project_eco.post.Post;
import com.bitcamp.team_project_eco.user.User;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter @Setter
public class NewCommentVO {
    String regDate;
    String comment;
    User user;
    Post post;
}
