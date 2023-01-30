
package com.bczchallenge.socialbesy.domain.mapper;

import com.bczchallenge.socialbesy.domain.dto.SeguidorDTO;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface SeguidorMapper {

    @Named("toDto")
    SeguidorDTO mapSeguidor(Seguidor seguidor);

    @Named("toEntity")
    Seguidor mapDTOSeguidor(SeguidorDTO seguidorDto);

    @IterableMapping(qualifiedByName = "toDTO")
    Iterable<SeguidorDTO> mapSeguidores(Iterable<Seguidor> seguidores);

    @IterableMapping(qualifiedByName = "toEntity")
    Iterable<Seguidor> mapSeguidoresDTO(Iterable<SeguidorDTO> seguidoresDto);
}

