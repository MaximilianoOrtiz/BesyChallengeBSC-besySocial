
package com.bczchallenge.socialbesy.domain.mapper;

import com.bczchallenge.socialbesy.domain.dto.SeguidorDTO;
import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface SeguidorMapper {

    @Mappings({
            @Mapping(source = "id" ,target = "idUser"),
            @Mapping(source = "nombreDeUsuario", target = "nombre_Usuario"),
            @Mapping(source = "seguidos" , target = "seguidos")
    })
    SeguidorDTO mapSeguidor(Seguidor seguidor);
}

