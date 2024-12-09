package com.shendyuk.cityManagement.controller;

import com.shendyuk.cityManagement.dto.PassportResponseDTO;
import com.shendyuk.cityManagement.mapper.PassportMapper;
import com.shendyuk.cityManagement.model.Passport;
import com.shendyuk.cityManagement.service.PassportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passports")
@AllArgsConstructor
public class PassportController {
    private PassportService passportService;
    private PassportMapper passportMapper;

    @GetMapping("/all")
    public List<PassportResponseDTO> findAllPassports() {
        List<Passport> passportList = passportService.findAll();
        return passportMapper.mapToListDTO(passportList);
    }

    @GetMapping("/{id}")
    public Passport findPassportById(@PathVariable Long id) {
        return passportService.findById(id);
    }
}
