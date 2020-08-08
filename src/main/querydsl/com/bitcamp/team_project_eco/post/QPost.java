package com.bitcamp.team_project_eco.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 1027355798L;

    public static final QPost post = new QPost("post");

    public final StringPath content = createString("content");

    public final StringPath date = createString("date");

    public final NumberPath<Integer> hits = createNumber("hits", Integer.class);

    public final StringPath img = createString("img");

    public final StringPath link = createString("link");

    public final NumberPath<Integer> postId = createNumber("postId", Integer.class);

    public final NumberPath<Integer> recomendation = createNumber("recomendation", Integer.class);

    public final StringPath titie = createString("titie");

    public QPost(String variable) {
        super(Post.class, forVariable(variable));
    }

    public QPost(Path<? extends Post> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPost(PathMetadata metadata) {
        super(Post.class, metadata);
    }

}

