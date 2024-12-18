package com.shendyuk.cityManagement.mapper;

import com.shendyuk.cityManagement.dto.PersonCreateRequestDTO;
import com.shendyuk.cityManagement.dto.PersonResponseDTO;
import com.shendyuk.cityManagement.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person mapToPerson(PersonCreateRequestDTO personCreateRequestDTO);

    @Mapping(target = "idPassport", source = "person.passport.id")
    @Mapping(target = "passportSeries", source = "person.passport.series")
    PersonResponseDTO mapToDTO(Person person);

    List<PersonResponseDTO> mapToListDTO (List<Person> listPerson);
}
