package com.bitcamp.team_project_eco.sights;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSights is a Querydsl query type for Sights
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSights extends EntityPathBase<Sights> {

    private static final long serialVersionUID = 1820213334L;

    public static final QSights sights = new QSights("sights");

    public final StringPath address = createString("address");

    public final ListPath<com.bitcamp.team_project_eco.bookmark.Bookmark, com.bitcamp.team_project_eco.bookmark.QBookmark> bookmarkList = this.<com.bitcamp.team_project_eco.bookmark.Bookmark, com.bitcamp.team_project_eco.bookmark.QBookmark>createList("bookmarkList", com.bitcamp.team_project_eco.bookmark.Bookmark.class, com.bitcamp.team_project_eco.bookmark.QBookmark.class, PathInits.DIRECT2);

    public final NumberPath<Integer> capacity = createNumber("capacity", Integer.class);

    public final StringPath category = createString("category");

    public final StringPath info = createString("info");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> parkingLot = createNumber("parkingLot", Integer.class);

    public final NumberPath<Long> sightsId = createNumber("sightsId", Long.class);

    public final StringPath streetAddress = createString("streetAddress");

    public final NumberPath<Double> xValue = createNumber("xValue", Double.class);

    public final NumberPath<Double> yValue = createNumber("yValue", Double.class);

    public QSights(String variable) {
        super(Sights.class, forVariable(variable));
    }

    public QSights(Path<? extends Sights> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSights(PathMetadata metadata) {
        super(Sights.class, metadata);
    }

}

