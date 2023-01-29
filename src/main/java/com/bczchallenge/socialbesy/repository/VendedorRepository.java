package com.bczchallenge.socialbesy.repository;

import com.bczchallenge.socialbesy.domain.mapper.models.Comprador;

public interface VendedorRepository  extends  UsuarioRepository{

    Iterable<Comprador> findCompradoresByIdVendedor(Integer idVendedor);

}