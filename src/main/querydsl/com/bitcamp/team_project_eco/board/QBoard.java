package com.bitcamp.team_project_eco.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 1778190086L;

    public static final QBoard board = new QBoard("board");

    public final NumberPath<Integer> boardHits = createNumber("boardHits", Integer.class);

    public final NumberPath<Integer> communityId = createNumber("communityId", Integer.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final StringPath hashTag = createString("hashTag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> recomendation = createNumber("recomendation", Integer.class);

    public final StringPath titie = createString("titie");

    public final DateTimePath<java.time.LocalDateTime> updateDate = createDateTime("updateDate", java.time.LocalDateTime.class);

    public final StringPath userId = createString("userId");

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

