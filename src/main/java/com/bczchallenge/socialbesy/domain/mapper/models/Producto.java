package com.bczchallenge.socialbesy.domain.mapper.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PRODUCTO")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "producto_nombre")
    private String nombreProducto;
    private String tipo;
    private String marca;
    private String color;
    private String observaciones;

}
