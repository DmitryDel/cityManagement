package com.shendyuk.cityManagement.mapper;

import com.shendyuk.cityManagement.dto.PersonCreateRequestDTO;
import com.shendyuk.cityManagement.dto.PersonResponseDTO;
import com.shendyuk.cityManagement.model.Passport;
import com.shendyuk.cityManagement.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-12T01:40:17+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person mapToPerson(PersonCreateRequestDTO personCreateRequestDTO) {
        if ( personCreateRequestDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setName( personCreateRequestDTO.getName() );

        return person;
    }

    @Override
    public PersonResponseDTO mapToDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonResponseDTO personResponseDTO = new PersonResponseDTO();

        Long id = personPassportId( person );
        if ( id != null ) {
            personResponseDTO.setIdPassport( String.valueOf( id ) );
        }
        personResponseDTO.setPassportSeries( personPassportSeries( person ) );
        personResponseDTO.setId( person.getId() );
        personResponseDTO.setName( person.getName() );

        return personResponseDTO;
    }

    @Override
    public List<PersonResponseDTO> mapToListDTO(List<Person> listPerson) {
        if ( listPerson == null ) {
            return null;
        }

        List<PersonResponseDTO> list = new ArrayList<PersonResponseDTO>( listPerson.size() );
        for ( Person person : listPerson ) {
            list.add( mapToDTO( person ) );
        }

        return list;
    }

    private Long personPassportId(Person person) {
        if ( person == null ) {
            return null;
        }
        Passport passport = person.getPassport();
        if ( passport == null ) {
            return null;
        }
        Long id = passport.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String personPassportSeries(Person person) {
        if ( person == null ) {
            return null;
        }
        Passport passport = person.getPassport();
        if ( passport == null ) {
            return null;
        }
        String series = passport.getSeries();
        if ( series == null ) {
            return null;
        }
        return series;
    }
}
