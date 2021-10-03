package com.khan.mysqljson.repo;

import com.khan.mysqljson.entity.CarEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    
}
