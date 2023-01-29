package com.bczchallenge.socialbesy.repository;

import com.bczchallenge.socialbesy.domain.models.Vendedor;

public interface UsuarioRepository {
    Iterable<Vendedor> findVendedoresByIdUsuario(Integer usuarioId);

}
