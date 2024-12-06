package com.shendyuk.cityManagement.mapper;

import com.shendyuk.cityManagement.dto.CarCreateRequestDTO;
import com.shendyuk.cityManagement.dto.CarResponseDTO;
import com.shendyuk.cityManagement.model.Car;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-29T20:17:04+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car mapToCar(CarCreateRequestDTO carCreateRequestDTO) {
        if ( carCreateRequestDTO == null ) {
            return null;
        }

        Car car = new Car();

        car.setModel( carCreateRequestDTO.getModel() );
        car.setManufactureYear( carCreateRequestDTO.getManufactureYear() );

        return car;
    }

    @Override
    public CarResponseDTO mapToDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        CarResponseDTO carResponseDTO = new CarResponseDTO();

        carResponseDTO.setId( car.getId() );
        carResponseDTO.setModel( car.getModel() );
        carResponseDTO.setManufactureYear( car.getManufactureYear() );

        return carResponseDTO;
    }

    @Override
    public List<CarResponseDTO> mapToListDTO(List<Car> carList) {
        if ( carList == null ) {
            return null;
        }

        List<CarResponseDTO> list = new ArrayList<CarResponseDTO>( carList.size() );
        for ( Car car : carList ) {
            list.add( mapToDTO( car ) );
        }

        return list;
    }
}
