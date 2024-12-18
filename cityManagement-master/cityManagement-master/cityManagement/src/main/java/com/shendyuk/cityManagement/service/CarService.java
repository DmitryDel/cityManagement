package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    Car findById(Long id);

    Car save(Car car);

    void deleteById(Long id);
}
