package com.bitcamp.team_project_eco.wishlist;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWishlist is a Querydsl query type for Wishlist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWishlist extends EntityPathBase<Wishlist> {

    private static final long serialVersionUID = 1745772342L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWishlist wishlist = new QWishlist("wishlist");

    public final com.bitcamp.team_project_eco.electriccar.QElectricCar electricCar;

    public final com.bitcamp.team_project_eco.user.QUser user;

    public final NumberPath<Long> wishlistId = createNumber("wishlistId", Long.class);

    public QWishlist(String variable) {
        this(Wishlist.class, forVariable(variable), INITS);
    }

    public QWishlist(Path<? extends Wishlist> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWishlist(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWishlist(PathMetadata metadata, PathInits inits) {
        this(Wishlist.class, metadata, inits);
    }

    public QWishlist(Class<? extends Wishlist> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.electricCar = inits.isInitialized("electricCar") ? new com.bitcamp.team_project_eco.electriccar.QElectricCar(forProperty("electricCar")) : null;
        this.user = inits.isInitialized("user") ? new com.bitcamp.team_project_eco.user.QUser(forProperty("user")) : null;
    }

}

