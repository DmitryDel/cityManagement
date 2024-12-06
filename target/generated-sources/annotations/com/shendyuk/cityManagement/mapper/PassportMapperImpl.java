package com.shendyuk.cityManagement.mapper;

import com.shendyuk.cityManagement.dto.PassportCreateRequestDTO;
import com.shendyuk.cityManagement.dto.PassportResponseDTO;
import com.shendyuk.cityManagement.model.Passport;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T00:11:38+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PassportMapperImpl implements PassportMapper {

    @Override
    public Passport mapToPassport(PassportCreateRequestDTO passportCreateRequestDTO) {
        if ( passportCreateRequestDTO == null ) {
            return null;
        }

        Passport passport = new Passport();

        return passport;
    }

    @Override
    public PassportResponseDTO mapToDTO(Passport passport) {
        if ( passport == null ) {
            return null;
        }

        PassportResponseDTO passportResponseDTO = new PassportResponseDTO();

        passportResponseDTO.setId( passport.getId() );
        passportResponseDTO.setSeries( passport.getSeries() );
        passportResponseDTO.setIssueData( passport.getIssueData() );

        return passportResponseDTO;
    }

    @Override
    public List<PassportResponseDTO> mapToListDTO(List<Passport> passportList) {
        if ( passportList == null ) {
            return null;
        }

        List<PassportResponseDTO> list = new ArrayList<PassportResponseDTO>( passportList.size() );
        for ( Passport passport : passportList ) {
            list.add( mapToDTO( passport ) );
        }

        return list;
    }
}
