package com.shendyuk.cityManagement.repository;

import com.shendyuk.cityManagement.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);
}
