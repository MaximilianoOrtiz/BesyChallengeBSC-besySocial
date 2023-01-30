package com.bczchallenge.socialbesy.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "SEGUIDOR")
public class Seguidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_de_usuario")
    private String nombreDeUsuario;

    @ManyToMany(
            mappedBy = "seguidores"
    )
    @JsonIgnoreProperties({"seguidores"})
    private Set<Usuario> seguidos;

}
