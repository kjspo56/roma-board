package com.kjs.roma.model.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1842726733L;

    public static final QMember member = new QMember("member1");

    public final com.kjs.roma.model.QCommonField _super = new com.kjs.roma.model.QCommonField(this);

    public final StringPath department = createString("department");

    public final StringPath email = createString("email");

    public final DateTimePath<java.sql.Timestamp> lastAccessTime = createDateTime("lastAccessTime", java.sql.Timestamp.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    //inherited
    public final NumberPath<Integer> modMember = _super.modMember;

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath refreshToken = createString("refreshToken");

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    //inherited
    public final NumberPath<Integer> regMember = _super.regMember;

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final StringPath token = createString("token");

    public final StringPath username = createString("username");

    public final StringPath userStatus = createString("userStatus");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

