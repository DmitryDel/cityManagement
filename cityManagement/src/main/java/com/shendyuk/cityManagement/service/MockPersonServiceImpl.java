package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.aspect.RobinHood;
import com.shendyuk.cityManagement.model.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockPersonServiceImpl implements PersonService {
    @Override
    public List<Person> findAll() {
        return List.of();
    }

    @Override
    @RobinHood
    public Person randomPerson() {
        return null;
    }

    @Override
    public Person findById(Long id) {
        return null;
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByName(String name) {

    }
}
