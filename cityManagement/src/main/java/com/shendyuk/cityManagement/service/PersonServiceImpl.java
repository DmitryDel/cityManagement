package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.aspect.RobinHood;
import com.shendyuk.cityManagement.model.Passport;
import com.shendyuk.cityManagement.model.Person;
import com.shendyuk.cityManagement.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service("PersonServiceImpl")
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private PassportService passportService;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @RobinHood
    public Person randomPerson() {
        List<Person> personsList = findAll();
        int randomPerson = new Random().nextInt(personsList.size());
        return personsList.get(randomPerson);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new com.shendyuk.cityManagement.exception.EntityNotFoundException("Человек" +
                "по указанномуID: " + id + " не найден."));
    }

    @Transactional
    public Person save(Person person) {
        personRepository.save(person);
        Passport passport = passportService.createNewPassport();
        passport.setPerson(person);
        passportService.save(passport);
        return person;
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public void deleteByName(String name) {
        Person person = personRepository.findByName(name);
        if(person != null) personRepository.delete(person);
        else throw new EntityNotFoundException("User with name " + name + " not found.");
    }
}
