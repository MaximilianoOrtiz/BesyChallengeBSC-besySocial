package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.models.Comprador;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import org.springframework.stereotype.Repository;


public interface VendedorInterface  extends UsuarioInterface{

    Iterable<Usuario> getListadosSeguidores(Integer idVendedor);
}
