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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final StringPath addr = createString("addr");

    public final StringPath adminCheck = createString("adminCheck");

    public final StringPath banDate = createString("banDate");

    public final StringPath email = createString("email");

    public final StringPath emailConfirm = createString("emailConfirm");

    public final StringPath grade = createString("grade");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath paymentInfo = createString("paymentInfo");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final com.bitcamp.team_project_eco.post.QPost post;

    public final StringPath profileImage = createString("profileImage");

    public final StringPath profileText = createString("profileText");

    public final StringPath registerDate = createString("registerDate");

    public final StringPath snsConfirm = createString("snsConfirm");

    public final StringPath ssr = createString("ssr");

    public final StringPath userId = createString("userId");

    public final NumberPath<Long> userSeq = createNumber("userSeq", Long.class);

    public final StringPath visitCount = createString("visitCount");

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new com.bitcamp.team_project_eco.post.QPost(forProperty("post"), inits.get("post")) : null;
    }

}

