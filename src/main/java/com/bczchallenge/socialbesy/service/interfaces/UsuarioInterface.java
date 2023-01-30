package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;

public interface UsuarioInterface {
    Iterable<Seguidor> getListadosSeguidores(Integer idVendedor);
}
