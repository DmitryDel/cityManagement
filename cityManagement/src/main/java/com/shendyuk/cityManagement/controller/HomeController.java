package com.shendyuk.cityManagement.controller;

import com.shendyuk.cityManagement.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homes")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

//    @PostMapping
//    public HouseResponseDTO createNewBuilding() {
//
//        return ;
//    }
}
