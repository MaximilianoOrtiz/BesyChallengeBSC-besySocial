package com.bczchallenge.socialbesy.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class DTOPublicacionResponse {

    Integer user_id;
    List<DTOPublicacionSinPromo> publicaciones;

}
