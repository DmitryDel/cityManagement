package com.shendyuk.cityManagement.controller;

import com.shendyuk.cityManagement.dto.HomeCreateRequestDTO;
import com.shendyuk.cityManagement.dto.HomeResponseDTO;
import com.shendyuk.cityManagement.exception.EntityNotFoundException;
import com.shendyuk.cityManagement.mapper.CarMapper;
import com.shendyuk.cityManagement.mapper.HomeMapper;
import com.shendyuk.cityManagement.model.Home;
import com.shendyuk.cityManagement.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;
    private final HomeMapper homeMapper;

    @GetMapping("/all")
    public List<HomeResponseDTO> findAllHomes() {
        List<Home> homeList = homeService.findAll();
        return homeMapper.mapToListDTO(homeList);
    }

    @GetMapping("/{id}")
    public HomeResponseDTO findHomeById(@PathVariable Long id) {
        Home home = homeService.findById(id);
        return homeMapper.mapToDTO(home);
    }

    @GetMapping("/homeaddress")
    public HomeResponseDTO findHomeByAddress(@RequestBody HomeCreateRequestDTO homeCreateRequestDTO) {
        Home home = homeService.findHome(homeCreateRequestDTO.getStreet(), homeCreateRequestDTO.getNumber());
        return homeMapper.mapToDTO(home);
    }

    @PostMapping("/create")
    public HomeResponseDTO createNewBuilding(@RequestBody HomeCreateRequestDTO homeCreateRequestDTO) {
        Home home = homeMapper.mapToHome(homeCreateRequestDTO);
        Home savedHome = homeService.save(home);
        return homeMapper.mapToDTO(savedHome);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHomeById(@PathVariable Long id) {
        try {
            homeService.deleteById(id);
            return ResponseEntity.ok("Дом по указанному ID: " + id + " удален.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
