package com.shendyuk.cityManagement.mapper;

import com.shendyuk.cityManagement.dto.CarCreateRequestDTO;
import com.shendyuk.cityManagement.dto.CarResponseDTO;
import com.shendyuk.cityManagement.model.Car;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car mapToCar(CarCreateRequestDTO carCreateRequestDTO);

    CarResponseDTO mapToDTO(Car car);

    List<CarResponseDTO> mapToListDTO(List<Car> carList);
}
