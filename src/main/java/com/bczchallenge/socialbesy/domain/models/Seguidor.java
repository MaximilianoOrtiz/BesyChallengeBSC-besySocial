package com.bczchallenge.socialbesy.domain.models;

import javax.persistence.*;
import java.util.Set;

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
    private Set<Usuario> seguidos;

}
