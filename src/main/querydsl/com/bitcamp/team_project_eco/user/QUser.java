package com.bitcamp.team_project_eco.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -635930762L;

    public static final QUser user = new QUser("user");

    public final StringPath addr = createString("addr");

    public final StringPath adminCheck = createString("adminCheck");

    public final StringPath banDate = createString("banDate");

    public final ListPath<com.bitcamp.team_project_eco.comment.Comment, com.bitcamp.team_project_eco.comment.QComment> comments = this.<com.bitcamp.team_project_eco.comment.Comment, com.bitcamp.team_project_eco.comment.QComment>createList("comments", com.bitcamp.team_project_eco.comment.Comment.class, com.bitcamp.team_project_eco.comment.QComment.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath emailConfirm = createString("emailConfirm");

    public final StringPath grade = createString("grade");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath paymentInfo = createString("paymentInfo");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<com.bitcamp.team_project_eco.post.Post, com.bitcamp.team_project_eco.post.QPost> postList = this.<com.bitcamp.team_project_eco.post.Post, com.bitcamp.team_project_eco.post.QPost>createList("postList", com.bitcamp.team_project_eco.post.Post.class, com.bitcamp.team_project_eco.post.QPost.class, PathInits.DIRECT2);

    public final StringPath profileImage = createString("profileImage");

    public final StringPath profileText = createString("profileText");

    public final StringPath registerDate = createString("registerDate");

    public final StringPath snsConfirm = createString("snsConfirm");

    public final StringPath ssr = createString("ssr");

    public final ListPath<com.bitcamp.team_project_eco.usedCar.UsedCar, com.bitcamp.team_project_eco.usedCar.QUsedCar> usedCarList = this.<com.bitcamp.team_project_eco.usedCar.UsedCar, com.bitcamp.team_project_eco.usedCar.QUsedCar>createList("usedCarList", com.bitcamp.team_project_eco.usedCar.UsedCar.class, com.bitcamp.team_project_eco.usedCar.QUsedCar.class, PathInits.DIRECT2);

    public final StringPath userId = createString("userId");

    public final NumberPath<Long> userSeq = createNumber("userSeq", Long.class);

    public final StringPath visitCount = createString("visitCount");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

