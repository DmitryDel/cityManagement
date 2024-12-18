package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.model.Car;
import com.shendyuk.cityManagement.model.Person;
import com.shendyuk.cityManagement.repository.CarRepository;
import com.shendyuk.cityManagement.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonReferenceService {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public void assignCarToPerson(Long personId, Long carId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found."));

        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found."));

        car.setOwner(person);
        person.getCars().add(car);
    }
}
