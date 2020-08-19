package com.bitcamp.team_project_eco.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {

    Optional<User> findByUserId(String userId);

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT sex, count(*) as count FROM user GROUP BY sex", nativeQuery = true)
    List<Map<String, Object>> counting();

    @Query(value = "select floor((year(now())-year(birth_date))/10)*10 age, count(birth_date) as cnt from user where birth_date!='' group by age", nativeQuery = true)
    List<Map<String, String>> countAge();
}
