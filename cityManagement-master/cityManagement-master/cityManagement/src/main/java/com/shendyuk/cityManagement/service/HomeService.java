package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.model.Home;

import java.util.List;

public interface HomeService {
    List<Home> findAll();

    Home findById(Long id);

    Home save(Home home);

    boolean isAddressExists(String street, int number);

    void deleteById(Long id);

    Home findHome(String street, int number);
}
