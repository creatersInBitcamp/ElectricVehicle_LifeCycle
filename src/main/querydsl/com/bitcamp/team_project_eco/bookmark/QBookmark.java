package com.bitcamp.team_project_eco.bookmark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookmark is a Querydsl query type for Bookmark
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBookmark extends EntityPathBase<Bookmark> {

    private static final long serialVersionUID = -2005520810L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBookmark bookmark = new QBookmark("bookmark");

    public final NumberPath<Long> bookmarkId = createNumber("bookmarkId", Long.class);

    public final com.bitcamp.team_project_eco.chargingStation.QChargingStation chargingStation;

    public final com.bitcamp.team_project_eco.sights.QSights sights;

    public final com.bitcamp.team_project_eco.user.QUser user;

    public QBookmark(String variable) {
        this(Bookmark.class, forVariable(variable), INITS);
    }

    public QBookmark(Path<? extends Bookmark> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBookmark(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBookmark(PathMetadata metadata, PathInits inits) {
        this(Bookmark.class, metadata, inits);
    }

    public QBookmark(Class<? extends Bookmark> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chargingStation = inits.isInitialized("chargingStation") ? new com.bitcamp.team_project_eco.chargingStation.QChargingStation(forProperty("chargingStation")) : null;
        this.sights = inits.isInitialized("sights") ? new com.bitcamp.team_project_eco.sights.QSights(forProperty("sights")) : null;
        this.user = inits.isInitialized("user") ? new com.bitcamp.team_project_eco.user.QUser(forProperty("user")) : null;
    }

}

