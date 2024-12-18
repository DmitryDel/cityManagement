package com.shendyuk.cityManagement.repository;

import com.shendyuk.cityManagement.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
