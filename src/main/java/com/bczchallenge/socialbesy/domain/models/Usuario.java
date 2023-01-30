package com.bczchallenge.socialbesy.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public abstract class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_de_usuario")
    private String nombreDeUsuario;
/*
    @ManyToMany(
            mappedBy = "seguidores",
            fetch = FetchType.LAZY
    )
    private Set<Vendedor> seguidos;*/
}
/*

    @OneToMany(
            mappedBy = "usuario",
            fetch = FetchType.LAZY
    )
   //private Set<Publicacion> publicaciones;

}
*/
