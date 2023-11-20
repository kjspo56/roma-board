package com.kjs.roma.model.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -239283213L;

    public static final QPost post = new QPost("post");

    public final com.kjs.roma.model.QCommonField _super = new com.kjs.roma.model.QCommonField(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    //inherited
    public final NumberPath<Integer> modMember = _super.modMember;

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public final NumberPath<Integer> postLike = createNumber("postLike", Integer.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    //inherited
    public final NumberPath<Integer> regMember = _super.regMember;

    public final StringPath title = createString("title");

    public final NumberPath<Integer> view = createNumber("view", Integer.class);

    public final StringPath writer = createString("writer");

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

