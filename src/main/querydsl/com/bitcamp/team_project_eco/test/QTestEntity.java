package com.bitcamp.team_project_eco.test;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTestEntity is a Querydsl query type for TestEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTestEntity extends EntityPathBase<TestEntity> {

    private static final long serialVersionUID = 980153177L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTestEntity testEntity = new QTestEntity("testEntity");

    public final com.bitcamp.team_project_eco.electriccar.QElectricCar eeletricCar;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.bitcamp.team_project_eco.user.QUser user;

    public final StringPath yyyymmdd = createString("yyyymmdd");

    public QTestEntity(String variable) {
        this(TestEntity.class, forVariable(variable), INITS);
    }

    public QTestEntity(Path<? extends TestEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTestEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTestEntity(PathMetadata metadata, PathInits inits) {
        this(TestEntity.class, metadata, inits);
    }

    public QTestEntity(Class<? extends TestEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.eeletricCar = inits.isInitialized("eeletricCar") ? new com.bitcamp.team_project_eco.electriccar.QElectricCar(forProperty("eeletricCar")) : null;
        this.user = inits.isInitialized("user") ? new com.bitcamp.team_project_eco.user.QUser(forProperty("user")) : null;
    }

}

