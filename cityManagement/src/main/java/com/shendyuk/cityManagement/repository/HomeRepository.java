package com.shendyuk.cityManagement.repository;

import com.shendyuk.cityManagement.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home, Long> {
    List<Home> id(Long id);

    Home findByStreetAndNumber(String street, int number);
}
