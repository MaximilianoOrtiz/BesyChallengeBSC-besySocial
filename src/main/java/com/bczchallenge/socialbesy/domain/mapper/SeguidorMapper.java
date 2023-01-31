
package com.bczchallenge.socialbesy.domain.mapper;

import com.bczchallenge.socialbesy.domain.dto.DTOQuienMeSigue;
import com.bczchallenge.socialbesy.domain.dto.DTOSeguidor;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SeguidorMapper {

    @Mappings({
            @Mapping(source = "id", target = "idUser"),
            @Mapping(source = "nombreDeSeguidor", target = "nombre_Seguidor"),
    })
    DTOQuienMeSigue mapQuienMeSigue(Seguidor seguidor);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombreDeSeguidor", target = "nombre_Seguidor"),
    })
    DTOSeguidor mapSeguidor(Seguidor seguidor);


}


