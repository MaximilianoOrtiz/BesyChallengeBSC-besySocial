package com.bczchallenge.socialbesy.domain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PUBLICACION")
public class Publicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //private Vendedor vendedor;

    private String fecha;

    private double Precio;

}
