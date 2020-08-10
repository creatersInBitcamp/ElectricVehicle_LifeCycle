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

    public final StringPath banDate = createString("banDate");

    public final StringPath birthDate = createString("birthDate");

    public final ListPath<com.bitcamp.team_project_eco.bookmark.Bookmark, com.bitcamp.team_project_eco.bookmark.QBookmark> bookmarkList = this.<com.bitcamp.team_project_eco.bookmark.Bookmark, com.bitcamp.team_project_eco.bookmark.QBookmark>createList("bookmarkList", com.bitcamp.team_project_eco.bookmark.Bookmark.class, com.bitcamp.team_project_eco.bookmark.QBookmark.class, PathInits.DIRECT2);


    public final ListPath<com.bitcamp.team_project_eco.comment.Comment, com.bitcamp.team_project_eco.comment.QComment> commentList = this.<com.bitcamp.team_project_eco.comment.Comment, com.bitcamp.team_project_eco.comment.QComment>createList("commentList", com.bitcamp.team_project_eco.comment.Comment.class, com.bitcamp.team_project_eco.comment.QComment.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final BooleanPath emailConfirm = createBoolean("emailConfirm");

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath paymentInfo = createString("paymentInfo");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<com.bitcamp.team_project_eco.post.Post, com.bitcamp.team_project_eco.post.QPost> postList = this.<com.bitcamp.team_project_eco.post.Post, com.bitcamp.team_project_eco.post.QPost>createList("postList", com.bitcamp.team_project_eco.post.Post.class, com.bitcamp.team_project_eco.post.QPost.class, PathInits.DIRECT2);

    public final StringPath profileImage = createString("profileImage");

    public final StringPath profileText = createString("profileText");

    public final ListPath<com.bitcamp.team_project_eco.purchase.Purchase, com.bitcamp.team_project_eco.purchase.QPurchase> purchasesList = this.<com.bitcamp.team_project_eco.purchase.Purchase, com.bitcamp.team_project_eco.purchase.QPurchase>createList("purchasesList", com.bitcamp.team_project_eco.purchase.Purchase.class, com.bitcamp.team_project_eco.purchase.QPurchase.class, PathInits.DIRECT2);

    public final StringPath registerDate = createString("registerDate");

    public final StringPath sex = createString("sex");

    public final BooleanPath snsConfirm = createBoolean("snsConfirm");

    public final ListPath<com.bitcamp.team_project_eco.usedCar.UsedCar, com.bitcamp.team_project_eco.usedCar.QUsedCar> usedCarList = this.<com.bitcamp.team_project_eco.usedCar.UsedCar, com.bitcamp.team_project_eco.usedCar.QUsedCar>createList("usedCarList", com.bitcamp.team_project_eco.usedCar.UsedCar.class, com.bitcamp.team_project_eco.usedCar.QUsedCar.class, PathInits.DIRECT2);

    public final StringPath userId = createString("userId");

    public final NumberPath<Long> userSeq = createNumber("userSeq", Long.class);

    public final NumberPath<Integer> visitCount = createNumber("visitCount", Integer.class);

    public final ListPath<com.bitcamp.team_project_eco.wishlist.Wishlist, com.bitcamp.team_project_eco.wishlist.QWishlist> wishlistList = this.<com.bitcamp.team_project_eco.wishlist.Wishlist, com.bitcamp.team_project_eco.wishlist.QWishlist>createList("wishlistList", com.bitcamp.team_project_eco.wishlist.Wishlist.class, com.bitcamp.team_project_eco.wishlist.QWishlist.class, PathInits.DIRECT2);

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

