package com.bitcamp.team_project_eco.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface CustomUserRepository {
    Optional<User> findByUserId(String userId);
}
@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements CustomUserRepository{

    private final  JPAQueryFactory queryFactory;
    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        return Optional.empty();
    }
}
