package com.bczchallenge.socialbesy.domain.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
