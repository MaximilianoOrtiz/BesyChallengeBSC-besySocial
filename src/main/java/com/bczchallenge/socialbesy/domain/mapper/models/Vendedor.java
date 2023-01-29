package com.bczchallenge.socialbesy.domain.mapper.models;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity()
@Table(name = "VENDEDOR")
@PrimaryKeyJoinColumn()
public class Vendedor extends Usuario{

    //@Column(name = "usuarios_seguidores")


    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "vendedor_usuario",
            joinColumns = @JoinColumn(name = "vendedor_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> seguidores;

    @OneToMany(
            mappedBy = "vendedor",
            fetch = FetchType.LAZY
    )
    private Set<Publicacion> publicaciones;

}
