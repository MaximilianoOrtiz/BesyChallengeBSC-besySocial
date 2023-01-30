
package com.bczchallenge.socialbesy.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PUBLICACIONES")
@AllArgsConstructor
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

    @ManyToOne(
            optional = false,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;


    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = String.valueOf(LocalDateTime.now());
    }

}

