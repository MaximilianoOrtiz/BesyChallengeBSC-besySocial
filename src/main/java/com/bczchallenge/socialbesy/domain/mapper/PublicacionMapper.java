package com.bczchallenge.socialbesy.domain.mapper;

import com.bczchallenge.socialbesy.domain.dto.DTOPublicacionPromocion;
import com.bczchallenge.socialbesy.domain.dto.DTOPublicacionSinPromo;
import com.bczchallenge.socialbesy.domain.models.Publicacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PublicacionMapper {

    @Mappings({
            @Mapping(source = "fechaAlta", target = "fecha_alta"),
            @Mapping(source = "producto.id", target= "detalle.producto_ID"),
            @Mapping(source = "producto.nombreProducto", target= "detalle.producto_nombre"),
            @Mapping(source = "producto.tipo", target= "detalle.tipo"),
            @Mapping(source = "producto.marca", target= "detalle.marca"),
            @Mapping(source = "producto.color", target= "detalle.color"),
            @Mapping(source = "producto.observaciones", target= "detalle.observaciones")
    })
    DTOPublicacionSinPromo mapPublicacionSinPromo(Publicacion publicacion);

    @Mappings({
            @Mapping(source = "fechaAlta", target = "fecha"),
            @Mapping(source = "producto.id", target= "detalle.producto_ID"),
            @Mapping(source = "producto.nombreProducto", target= "detalle.producto_nombre"),
            @Mapping(source = "producto.tipo", target= "detalle.tipo"),
            @Mapping(source = "producto.marca", target= "detalle.marca"),
            @Mapping(source = "producto.color", target= "detalle.color"),
            @Mapping(source = "producto.observaciones", target= "detalle.observaciones"),
            @Mapping(source = "enPromocion", target= "en_promocion"),
            @Mapping(source = "precioDescuento", target= "precio_descuento"),
    })
    DTOPublicacionPromocion mapPublicacionPromo(Publicacion publicacion);
}
