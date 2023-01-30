package com.bczchallenge.socialbesy.repository;


import com.bczchallenge.socialbesy.domain.models.Comprador;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("vendedorRepository")
public interface VendedorRepository  extends  UsuarioRepository{

    @Query("select v.compradores from Vendedor v where v.id = ?1")
    Iterable<Usuario> findSeguidoresByIdVendedor(Integer idVendedor);

}
