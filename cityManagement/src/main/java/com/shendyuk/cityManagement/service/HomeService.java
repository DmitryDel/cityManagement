package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.exception.EntityNotFoundException;
import com.shendyuk.cityManagement.model.Home;
import com.shendyuk.cityManagement.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final HomeRepository homeRepository;

    public List<Home> findAll() {
        return homeRepository.findAll();
    }

    public Home findById(Long id) {
        return homeRepository.findById(id).orElseThrow();
    }

    public Home save(Home home) {
        return homeRepository.save(home);
    }

    public void deleteById(Long id) {
        if(homeRepository.existsById(id)) {
            homeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Дом по указанному ID: " + id + " не найден.");
        }
    }

    /**
     * Finds a Home by its street and number.
     *
     * @param street the street of the home
     * @param number the number of the home
     * @return the Home instance if found, or null if not found
     * @throws IllegalArgumentException if the street is null or empty
     */
    public Home findHome(String street, int number) {
        if (street == null || street.isEmpty()) throw new IllegalArgumentException("Название улицы не может быть пустым.");

        return homeRepository.findByStreetAndNumber(street, number);
    }
}
