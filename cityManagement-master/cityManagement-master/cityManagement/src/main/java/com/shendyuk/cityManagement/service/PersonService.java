package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person randomPerson();

    Person findById(Long id);

    Person save(Person person);

    void deleteById(Long id);

    void deleteByName(String name);
}
