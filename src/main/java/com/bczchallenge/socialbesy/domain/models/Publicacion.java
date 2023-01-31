
package com.bczchallenge.socialbesy.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PUBLICACION")
public class Publicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha_alta")
    private String fechaAlta;
//    @OneToOne
//    private Categoria categoria;
    private Integer categoria;
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
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", categoria=" + categoria +
                ", producto=" + producto +
                ", precio=" + precio +
                ", precioDescuento=" + precioDescuento +
                ", descuento=" + descuento +
                ", enPromocion=" + enPromocion +
                ", usuario=" + usuario +
                '}';
    }


  /*  @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = String.valueOf(LocalDateTime.now());
    }
*/
}

