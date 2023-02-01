package com.bczchallenge.socialbesy.domain.dto;

import lombok.Data;

@Data
public class DTOPublicacionPromocion {

    Integer id;
    String fecha;
    ProductoDTO detalle;
    Integer categoria;
    double precio;
    double precio_descuento;
    boolean en_promocion;
    double descuento;
}
