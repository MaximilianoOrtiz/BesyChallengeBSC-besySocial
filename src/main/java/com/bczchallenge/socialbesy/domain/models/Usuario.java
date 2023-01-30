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
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy= InheritanceType.JOINED)
public  class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_de_usuario")
    private String nombreDeUsuario;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
 //                   CascadeType.PERSIST,
//                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "usuario_seguidor",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "seguidor_id")
    )
    private Set<Seguidor> seguidores;

    @OneToMany(
            mappedBy = "usuario",
            fetch = FetchType.LAZY
    )
    @Column(name = "publicaciones")
    private Set<Publicacion> publicaciones;

}

