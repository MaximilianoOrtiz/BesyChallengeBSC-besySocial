package com.bczchallenge.socialbesy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    Integer producto_ID;
    String producto_nombre;
    String tipo;
    String marca;
    String color;
    String observaciones;

}
