package com.bitcamp.team_project_eco.usedCar;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface UsedCarService extends JpaService<UsedCar> {

}

@Service
public class UsedCarServiceImpl implements UsedCarService {
    private final UsedCarRepository usedCarRepository;

    public UsedCarServiceImpl(UsedCarRepository usedCarRepository) {
        this.usedCarRepository = usedCarRepository;
    }

    @Override
    public Optional<UsedCar> findById(String id) {
        return usedCarRepository.findById((long) Integer.parseInt(id));
    }

    @Override
    public Iterable<UsedCar> findAll() {
        return usedCarRepository.findAll();
    }

    @Override
    public int count() {
        return (int) usedCarRepository.count();
    }

    @Override
    public void delete(String id) {
        usedCarRepository.delete(findById(id).orElse(new UsedCar()));
    }

    @Override
    public boolean exists(String id) {
        return usedCarRepository.existsById((long) Integer.parseInt(id));
    }
}