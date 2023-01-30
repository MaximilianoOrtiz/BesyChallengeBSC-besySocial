package com.bczchallenge.socialbesy.repository;


import com.bczchallenge.socialbesy.domain.models.Comprador;
import org.springframework.stereotype.Repository;

@Repository("vendedorRepository")
public interface VendedorRepository  extends  UsuarioRepository{

    Iterable<Comprador> findSeguidoresByIdVendedor(Integer idVendedor);

}
