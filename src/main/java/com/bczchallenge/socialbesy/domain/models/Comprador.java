package com.bczchallenge.socialbesy.domain.models;

import lombok.Data;

import javax.persistence.*;


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