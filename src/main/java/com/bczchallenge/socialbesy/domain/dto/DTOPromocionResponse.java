package com.bczchallenge.socialbesy.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class DTOPromocionResponse {
    Integer user_id;
    String nombre_usuario;
    List<DTOPublicacionPromocion> publicaciones;
    Integer categoria;
}
