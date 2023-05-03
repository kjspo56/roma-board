package com.kjs.roma.model.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1902569773L;

    public static final QUser user = new QUser("user");

    public final com.kjs.roma.model.QCommonField _super = new com.kjs.roma.model.QCommonField(this);

    public final StringPath email = createString("email");

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    //inherited
    public final NumberPath<Integer> modMember = _super.modMember;

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    //inherited
    public final NumberPath<Integer> regMember = _super.regMember;

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath username = createString("username");

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

