package com.bczchallenge.socialbesy.domain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PRODUCTO")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
