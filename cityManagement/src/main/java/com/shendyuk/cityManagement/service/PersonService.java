package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.model.Person;
import com.shendyuk.cityManagement.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new com.shendyuk.cityManagement.exception.EntityNotFoundException("Человек" +
                "по указанномуID: " + id + " не найден."));
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        Person person = personRepository.findByName(name);

        if(person != null) personRepository.delete(person);
        else throw new EntityNotFoundException("User with name " + name + " not found.");
    }
}
