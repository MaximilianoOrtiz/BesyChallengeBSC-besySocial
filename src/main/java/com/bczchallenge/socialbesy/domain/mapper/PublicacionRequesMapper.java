package com.bczchallenge.socialbesy.domain.mapper;

import com.bczchallenge.socialbesy.domain.dto.PublicacionRequestDTO;
import com.bczchallenge.socialbesy.domain.models.Producto;
import com.bczchallenge.socialbesy.domain.models.Publicacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PublicacionRequesMapper {

    @Mappings({
            @Mapping(source = "fecha", target = "fechaAlta"),
            @Mapping(source = "precio", target = "precio"),
            @Mapping(source = "categoria", target = "categoria")
    })
    Publicacion publicacionMapper (PublicacionRequestDTO publicacionRequestDTO);


    @Mappings({
            @Mapping(source = "detalle.producto_ID", target = "id"),
            @Mapping(source = "detalle.producto_nombre", target = "nombreProducto"),
            @Mapping(source = "detalle.tipo", target = "tipo"),
            @Mapping(source = "detalle.marca", target = "marca"),
            @Mapping(source = "detalle.color", target = "color"),
            @Mapping(source = "detalle.observaciones", target = "observaciones")

    })
    Producto  productorMapper(PublicacionRequestDTO publicacionRequestDTO);


    @Mappings({
            @Mapping(source = "fecha", target = "fechaAlta"),
            @Mapping(source = "precio", target = "precio"),
            @Mapping(source = "categoria", target = "categoria"),
            @Mapping(source = "en_promocion", target = "enPromocion"),
            @Mapping(source = "descuento", target = "descuento"),
    })
    Publicacion promocionMapper(PublicacionRequestDTO publicacionRequestDTO);
}
