package com.bczchallenge.socialbesy.domain.dto;

import com.bczchallenge.socialbesy.domain.models.Usuario;
import lombok.Data;

import java.util.Set;

@Data
public class SeguidorDTO {

    int id;
    String nombreUsuario;
    Set<Usuario> seguidos;
}
