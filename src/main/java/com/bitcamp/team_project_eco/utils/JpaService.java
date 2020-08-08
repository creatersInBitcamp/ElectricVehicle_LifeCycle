package com.bitcamp.team_project_eco.utils;

import java.util.Optional;

public interface JpaService<T> {
    // 공통 인터페이스 기능
    public Optional<T> findById(String id);
    public Iterable<T> findAll();
    public int count();
    public void delete(String id);
    public boolean exists(String id);

}
