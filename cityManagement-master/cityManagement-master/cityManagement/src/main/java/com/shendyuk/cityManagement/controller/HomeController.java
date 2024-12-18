//package com.shendyuk.cityManagement.controller;
//
//import com.shendyuk.cityManagement.dto.HomeCreateRequestDTO;
//import com.shendyuk.cityManagement.dto.HomeResponseDTO;
//import com.shendyuk.cityManagement.exception.EntityNotFoundException;
//import com.shendyuk.cityManagement.mapper.HomeMapper;
//import com.shendyuk.cityManagement.model.Home;
//import com.shendyuk.cityManagement.service.HomeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/home")
//@RequiredArgsConstructor
//public class HomeController {
//    private final HomeService homeService;
//    private final HomeMapper homeMapper;
//
//    @GetMapping("/all")
//    public List<HomeResponseDTO> findAllHomes() {
//        List<Home> homeList = homeService.findAll();
//        return homeMapper.mapToListDTO(homeList);
//    }
//
//    @GetMapping("/{id}")
//    public HomeResponseDTO findHomeById(@PathVariable Long id) {
//        Home home = homeService.findById(id);
//        return homeMapper.mapToDTO(home);
//    }
//
//    @GetMapping("/homeaddress")
//    public ResponseEntity<?> findHomeByAddress(@RequestBody HomeCreateRequestDTO homeCreateRequestDTO) {
//        try {
//            Home home = homeService.findHome(homeCreateRequestDTO.getStreet(), homeCreateRequestDTO.getNumber());
//            return new ResponseEntity<>(homeMapper.mapToDTO(home), HttpStatus.OK);
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
////        Home home = homeService.findHome(homeCreateRequestDTO.getStreet(), homeCreateRequestDTO.getNumber());
////        return new ResponseEntity<>(homeMapper.mapToDTO(home), HttpStatus.OK);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<HomeResponseDTO> createNewBuilding(@RequestBody HomeCreateRequestDTO homeCreateRequestDTO) {
//            Home home = homeMapper.mapToHome(homeCreateRequestDTO);
//            Home savedHome = homeService.save(home);
//            return new ResponseEntity<>(homeMapper.mapToDTO(savedHome), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteHomeById(@PathVariable Long id) {
//        try {
//            homeService.deleteById(id);
//            return ResponseEntity.ok("Дом по указанному ID: " + id + " удален.");
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }
//}
