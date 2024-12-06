package com.shendyuk.cityManagement.controller;

import com.shendyuk.cityManagement.dto.HomeCreateRequestDTO;
import com.shendyuk.cityManagement.dto.HomeResponseDTO;
import com.shendyuk.cityManagement.mapper.HomeMapper;
import com.shendyuk.cityManagement.model.Home;
import com.shendyuk.cityManagement.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homes")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;
    private final HomeMapper homeMapper;

//    @GetMapping("/home")
//    public ResponseEntity<String> findHome(@RequestBody HomeCreateRequestDTO homeCreateRequestDTO) {
//        homeService.findHome(homeCreateRequestDTO.getStreet(), homeCreateRequestDTO.getNumber());
//        return ResponseEntity.ok("Home find by street " + homeCreateRequestDTO.getStreet());
//    }

    @PostMapping("/create")
    public HomeResponseDTO createNewBuilding(@RequestBody HomeCreateRequestDTO homeCreateRequestDTO) {
        Home home = homeMapper.mapToHome(homeCreateRequestDTO);
        Home savedHome = homeService.save(home);
        return homeMapper.mapToDTO(savedHome);
    }
}
