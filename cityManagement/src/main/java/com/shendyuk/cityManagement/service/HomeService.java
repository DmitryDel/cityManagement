package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.model.Home;
import com.shendyuk.cityManagement.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        homeRepository.deleteById(id);
    }

    public Home findHome(String street, int number) {
        return homeRepository.findHome(street, number);
    }
}
