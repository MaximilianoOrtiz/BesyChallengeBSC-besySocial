package com.bczchallenge.socialbesy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionRequestDTO {
    Integer userID;
    String fecha;
    ProductoDTO detalle;
    Integer categoria;
    Double precio;
}
