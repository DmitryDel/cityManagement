package com.shendyuk.cityManagement.mapper;

import com.shendyuk.cityManagement.dto.HomeCreateRequestDTO;
import com.shendyuk.cityManagement.dto.HomeResponseDTO;
import com.shendyuk.cityManagement.model.Home;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HomeMapper {
    Home mapToHome(HomeCreateRequestDTO homeCreateRequestDTO);

    HomeResponseDTO mapToDTO(Home home);

    List<HomeResponseDTO> mapToListDTO(List<Home> homeList);
}
