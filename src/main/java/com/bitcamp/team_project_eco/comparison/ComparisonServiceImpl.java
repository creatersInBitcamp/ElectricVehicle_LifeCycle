package com.bitcamp.team_project_eco.comparison;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface ComparisonService extends JpaService<Comparison> {

}

@Service
public class ComparisonServiceImpl implements ComparisonService{

    @Override
    public Optional<Comparison> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Comparison> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }
}
