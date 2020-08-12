package com.bitcamp.team_project_eco.chargingStation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChargingStation is a Querydsl query type for ChargingStation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChargingStation extends EntityPathBase<ChargingStation> {

    private static final long serialVersionUID = 990492736L;

    public static final QChargingStation chargingStation = new QChargingStation("chargingStation");

    public final StringPath address = createString("address");

    public final StringPath agencyName = createString("agencyName");

    public final ListPath<com.bitcamp.team_project_eco.bookmark.Bookmark, com.bitcamp.team_project_eco.bookmark.QBookmark> bookmarkList = this.<com.bitcamp.team_project_eco.bookmark.Bookmark, com.bitcamp.team_project_eco.bookmark.QBookmark>createList("bookmarkList", com.bitcamp.team_project_eco.bookmark.Bookmark.class, com.bitcamp.team_project_eco.bookmark.QBookmark.class, PathInits.DIRECT2);

    public final StringPath boostingCharge = createString("boostingCharge");

    public final StringPath businessHours = createString("businessHours");

    public final StringPath category = createString("category");

    public final StringPath chargerId = createString("chargerId");

    public final StringPath chargerState = createString("chargerState");

    public final StringPath chargerType = createString("chargerType");

    public final NumberPath<Integer> chargerTypeID = createNumber("chargerTypeID", Integer.class);

    public final NumberPath<Long> chargingStationId = createNumber("chargingStationId", Long.class);

    public final StringPath phone = createString("phone");

    public final StringPath unitName = createString("unitName");

    public final StringPath updateDate = createString("updateDate");

    public final NumberPath<Double> xValue = createNumber("xValue", Double.class);

    public final NumberPath<Double> yValue = createNumber("yValue", Double.class);

    public QChargingStation(String variable) {
        super(ChargingStation.class, forVariable(variable));
    }

    public QChargingStation(Path<? extends ChargingStation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChargingStation(PathMetadata metadata) {
        super(ChargingStation.class, metadata);
    }

}

