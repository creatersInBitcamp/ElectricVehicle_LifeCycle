package com.bitcamp.team_project_eco.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1898681570L;

    public static final QUser user = new QUser("user");

    public final StringPath addr = createString("addr");

    public final StringPath admin_check = createString("admin_check");

    public final StringPath ban_date = createString("ban_date");

    public final StringPath email = createString("email");

    public final StringPath emailConfirm = createString("emailConfirm");

    public final StringPath grade = createString("grade");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath paymentInfo = createString("paymentInfo");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath profileImage = createString("profileImage");

    public final StringPath profileText = createString("profileText");

    public final StringPath registerDate = createString("registerDate");

    public final StringPath snsConfirm = createString("snsConfirm");

    public final StringPath ssr = createString("ssr");

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> userSeq = createNumber("userSeq", Integer.class);

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

