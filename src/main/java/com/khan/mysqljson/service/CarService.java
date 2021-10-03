package com.khan.mysqljson.service;

import java.util.Optional;

import com.khan.mysqljson.entity.CarEntity;
import com.khan.mysqljson.model.Car;
import com.khan.mysqljson.repo.CarRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {
    
    private final CarRepository repo;
    private final ModelMapper modelMapper;

    @Autowired
    public CarService(CarRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public Car createCar(Car car) {
        CarEntity entity = this.modelMapper.map(car, CarEntity.class);
        CarEntity saved = this.repo.save(entity);
        return this.modelMapper.map(saved, Car.class);
    }

    public Car getCar(int id) {
        Optional<CarEntity> entity = this.repo.findById(id);
        if (entity.isPresent()) {
            return this.modelMapper.map(entity.get(), Car.class);
        }
        throw new RuntimeException("No entity with id: " + id);
    }
}
