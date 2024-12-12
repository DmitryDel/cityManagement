package com.shendyuk.cityManagement.controller;

import com.shendyuk.cityManagement.dto.PersonCreateRequestDTO;
import com.shendyuk.cityManagement.dto.PersonResponseDTO;
import com.shendyuk.cityManagement.mapper.PersonMapper;
import com.shendyuk.cityManagement.model.Person;
import com.shendyuk.cityManagement.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@AllArgsConstructor
public class PeopleController {
    private PersonService personService;
    private PersonMapper personMapper;

    @GetMapping("/all")
    public List<PersonResponseDTO> findAllPeople() {
        List<Person> list = personService.findAll();
        List<PersonResponseDTO> listDTO = personMapper.mapToListDTO(list);
        return listDTO;
    }

    @GetMapping("/{id}")
    public PersonResponseDTO findPersonById(@PathVariable Long id) {
        Person person = personService.findById(id);
        PersonResponseDTO personResponseDTO = personMapper.mapToDTO(person);
        return personResponseDTO;
    }

    @PostMapping("/create")
    public PersonResponseDTO saveNewPerson(@RequestBody PersonCreateRequestDTO personCreateRequestDTO) {
        Person person = personMapper.mapToPerson(personCreateRequestDTO);
        Person savedPerson = personService.save(person);
        PersonResponseDTO personResponseDTO = personMapper.mapToDTO(savedPerson);
        return personResponseDTO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.ok("User with ID " + id + " has been deleted.");
    }

    @DeleteMapping("deleteByName/{name}")
    public ResponseEntity<String> deletePersonByName(@PathVariable String name) {
        try{
            personService.deleteByName(name);
            return ResponseEntity.ok("User with name " + name + " has been deleted.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with name " + name + " not found.");
        }
    }
}
