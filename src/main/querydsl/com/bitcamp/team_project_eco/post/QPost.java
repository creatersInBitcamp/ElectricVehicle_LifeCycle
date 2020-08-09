package com.bitcamp.team_project_eco.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 1027355798L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final ListPath<com.bitcamp.team_project_eco.comment.Comment, com.bitcamp.team_project_eco.comment.QComment> comments = this.<com.bitcamp.team_project_eco.comment.Comment, com.bitcamp.team_project_eco.comment.QComment>createList("comments", com.bitcamp.team_project_eco.comment.Comment.class, com.bitcamp.team_project_eco.comment.QComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final StringPath date = createString("date");

    public final NumberPath<Integer> hits = createNumber("hits", Integer.class);

    public final StringPath img = createString("img");

    public final StringPath link = createString("link");

    public final NumberPath<Integer> postId = createNumber("postId", Integer.class);

    public final NumberPath<Integer> recomendation = createNumber("recomendation", Integer.class);

    public final StringPath titie = createString("titie");

    public final com.bitcamp.team_project_eco.user.QUser user;

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.bitcamp.team_project_eco.user.QUser(forProperty("user")) : null;
    }

}

