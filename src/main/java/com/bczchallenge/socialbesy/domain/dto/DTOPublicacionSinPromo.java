package com.bczchallenge.socialbesy.domain.dto;

import com.bczchallenge.socialbesy.domain.models.Producto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;
@Data
public class DTOPublicacionSinPromo {

    Integer id;
    String fecha_alta;
    ProductoDTO detalle;
    Integer categoria;
    Double precio;
}
