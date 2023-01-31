package com.bczchallenge.socialbesy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSiguiendoDTO {

    private Integer idUser;
    private String nombre_Usuario;
    DTOQuienMeSigue sigue;
}
