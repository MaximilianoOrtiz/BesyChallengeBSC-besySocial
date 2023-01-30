package com.bczchallenge.socialbesy.domain.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private Integer idUser;
    private String nombre_Usuario;
    List<DTOQuienMeSigue> seguidores;

}
