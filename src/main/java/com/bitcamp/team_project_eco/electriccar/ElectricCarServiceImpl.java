package com.bitcamp.team_project_eco.electriccar;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface ElectricCarService extends JpaService<ElectricCar> {}

@Service
public class ElectricCarServiceImpl implements ElectricCarService{

    @Override
    public Optional<ElectricCar> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Iterable<ElectricCar> findAll() {
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
