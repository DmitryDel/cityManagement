package com.shendyuk.cityManagement.controller;

import com.shendyuk.cityManagement.dto.PersonReferenceRequestDTO;
import com.shendyuk.cityManagement.service.PersonReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refernce")
@AllArgsConstructor
public class PersonReferenceController {
    private final PersonReferenceService personReferenceService;

    @PostMapping("/car")
    public ResponseEntity<Void> assignCarToPerson(@RequestBody PersonReferenceRequestDTO personReferenceRequestDTO) {
        personReferenceService.assignCarToPerson(personReferenceRequestDTO.getPersonId(), personReferenceRequestDTO.getCarId());
        return ResponseEntity.ok().build();
    }
}
