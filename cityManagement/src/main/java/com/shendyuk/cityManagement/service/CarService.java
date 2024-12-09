package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.exception.EntityNotFoundException;
import com.shendyuk.cityManagement.model.Car;
import com.shendyuk.cityManagement.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Машина по указанному ID: %d не найдена.", id)));
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
