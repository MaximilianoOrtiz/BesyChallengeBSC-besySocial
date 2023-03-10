package com.bczchallenge.socialbesy.domain.mapper;

import com.bczchallenge.socialbesy.domain.dto.DTOSeguidor;
import com.bczchallenge.socialbesy.domain.dto.DTOSiguiendo;
import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mappings({
            @Mapping(source = "id" ,target = "idUser"),
            @Mapping(source = "nombreDeUsuario", target = "nombre_Usuario")
    })
    UsuarioDTO mapUsuario(Usuario usuario);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombreDeUsuario", target= "nombre_Seguido")
    })
    DTOSiguiendo mapSeguidor(Usuario usuario);

}
