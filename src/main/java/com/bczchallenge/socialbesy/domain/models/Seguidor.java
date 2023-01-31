package com.bczchallenge.socialbesy.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SEGUIDOR")
public class Seguidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_de_seguidor")
    private String nombreDeSeguidor;

    @ManyToMany(
            mappedBy = "seguidores"
    )
    @JsonIgnoreProperties({"seguidores"})
    private Set<Usuario> seguidos;

    @Override
    public String toString() {
        return "Seguidor{" +
                "id=" + id +
                ", nombreDeSeguidor='" + nombreDeSeguidor + '\'' +
                '}';
    }
}
