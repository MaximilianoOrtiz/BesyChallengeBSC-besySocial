package com.bczchallenge.socialbesy.domain.mapper;

import com.bczchallenge.socialbesy.domain.dto.DTOPromocioProducto;
import com.bczchallenge.socialbesy.domain.dto.PublicacionProductoDTO;
import com.bczchallenge.socialbesy.domain.models.Publicacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PromocioProductoMapper {

    @Mappings({
            @Mapping(source = "id", target = "publicacion_id"),
            @Mapping(source = "precioDescuento", target = "precio_descuento")
    })
    DTOPromocioProducto mapPromocio(Publicacion publicacion);


}
