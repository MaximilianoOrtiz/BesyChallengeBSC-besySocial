package com.bczchallenge.socialbesy.domain.mapper.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "COMPRADOR")
@PrimaryKeyJoinColumn()
public class Comprador extends Usuario{

    //@Column(name = "vendedores_seguidos")

/*
    @ManyToMany(
            mappedBy = "compradores",
            fetch = FetchType.LAZY
    )
    private Set<Vendedor> vendedores;*/

}
