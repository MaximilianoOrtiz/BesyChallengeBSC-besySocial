
package com.bczchallenge.socialbesy.domain.mapper.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "PUBLICACION")
public class Publicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha_alta")
    private String fechaAlta;
    @OneToOne
    private Categoria categoria;

    @OneToOne
    private Producto producto;
    private double precio;
    @Column(name = "precio_descuento")
    private double precioDescuento;
    private double descuento;
    @Column(name = "en_promocion")
    private boolean enPromocion;

    /*@ManyToOne(
            optional = true,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "vendedor_id")*/
    @OneToOne
    private Vendedor vendedor;



    public Publicacion(Categoria categoria, double precio, double precioDescuento, double descuento, boolean enPromocion) {
        this.categoria = categoria;
        this.precio = precio;
        this.precioDescuento = precioDescuento;
        this.descuento = descuento;
        this.enPromocion = enPromocion;
    }

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = String.valueOf(LocalDateTime.now());
    }

}

