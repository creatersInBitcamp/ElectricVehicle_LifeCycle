package com.bitcamp.team_project_eco.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

interface CarService {
    List<Car> findAll();

    Car[] searchByCarName(String car);
}

@Service
public class CarServiceImpl implements CarService{
    @Autowired CarRepository carRepository;
    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car[] searchByCarName(String car) {
        return carRepository.findAllByCarName(car);
    }

}
