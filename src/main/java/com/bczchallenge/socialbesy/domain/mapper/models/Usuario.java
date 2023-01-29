package com.bczchallenge.socialbesy.domain.mapper.models;

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
public abstract class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_de_usuario")
    private String nombreDeUsuario;

    @ManyToMany(
            mappedBy = "seguidores",
            fetch = FetchType.LAZY
    )
    private Set<Vendedor> seguidos;
}
/*

    @OneToMany(
            mappedBy = "usuario",
            fetch = FetchType.LAZY
    )
   //private Set<Publicacion> publicaciones;

}
*/
