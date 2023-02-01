package com.bczchallenge.socialbesy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO {
    Integer userID;
    String fecha;
    ProductoDTO detalle;
    Integer categoria;
    Double precio;
    Boolean en_promocion;
    Double descuento;

}
