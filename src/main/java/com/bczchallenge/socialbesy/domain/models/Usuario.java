package com.bczchallenge.socialbesy.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

   // @JsonIgnoreProperties({"seguidos"})
    @JsonIgnore
    private Set<Seguidor> seguidores;

    @OneToMany(
            mappedBy = "usuario",
            fetch = FetchType.LAZY
    )
    @Column(name = "publicaciones")
   // @JsonIgnoreProperties({"usuario"})
    @JsonIgnore
    private Set<Publicacion> publicaciones;

    public void insertarNuevoSeguidor(Seguidor seguidor){
        seguidores.add(seguidor);
    }


    public void insertarNuevaPublicacion(Publicacion publicacion){
        publicaciones.add(publicacion);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreDeUsuario='" + nombreDeUsuario + '\'' +
                '}';
    }
}

