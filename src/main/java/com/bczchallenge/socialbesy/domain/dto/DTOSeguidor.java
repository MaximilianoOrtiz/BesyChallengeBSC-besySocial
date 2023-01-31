package com.bczchallenge.socialbesy.domain.dto;

import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Set;

@Data
public class DTOSeguidor {

    private Integer id;
    private String nombre_Seguidor;
    private List<DTOSiguiendo> seguidos;

}
