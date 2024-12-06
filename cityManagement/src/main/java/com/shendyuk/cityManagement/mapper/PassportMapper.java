package com.shendyuk.cityManagement.mapper;

import com.shendyuk.cityManagement.dto.PassportCreateRequestDTO;
import com.shendyuk.cityManagement.dto.PassportResponseDTO;
import com.shendyuk.cityManagement.model.Passport;
import com.shendyuk.cityManagement.repository.PassportRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    Passport mapToPassport(PassportCreateRequestDTO passportCreateRequestDTO);

    PassportResponseDTO mapToDTO(Passport passport);

    List<PassportResponseDTO> mapToListDTO(List<Passport> passportList);
}
