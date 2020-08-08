package com.bitcamp.team_project_eco.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface CustomUserRepository {
    Optional<User> findByUserId(String userId);
}
@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements CustomUserRepository{
    @Autowired
    JPAQueryFactory queryFactory;

    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        return Optional.empty();
    }
}
