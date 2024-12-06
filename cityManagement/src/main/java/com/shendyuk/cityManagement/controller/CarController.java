package com.shendyuk.cityManagement.controller;

import com.shendyuk.cityManagement.dto.CarCreateRequestDTO;
import com.shendyuk.cityManagement.dto.CarResponseDTO;
import com.shendyuk.cityManagement.mapper.CarMapper;
import com.shendyuk.cityManagement.model.Car;
import com.shendyuk.cityManagement.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {
    private CarService carService;
    private CarMapper carMapper;

    @GetMapping("/all")
    public List<CarResponseDTO> findAllCars() {
        List<Car> carList = carService.findAll();
        return carMapper.mapToListDTO(carList);
    }

    @GetMapping("/{id}")
    public CarResponseDTO findById(@PathVariable Long id) {
        Car car = carService.findById(id);
        return carMapper.mapToDTO(car);
    }

    @PostMapping("/create")
    public CarResponseDTO saveNewCar(@RequestBody CarCreateRequestDTO carCreateRequestDTO) {
        Car car = carMapper.mapToCar(carCreateRequestDTO);
        Car saveCar = carService.save(car);
        return carMapper.mapToDTO(saveCar);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
