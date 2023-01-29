package com.bczchallenge.socialbesy.repository;

import com.bczchallenge.socialbesy.domain.mapper.models.Vendedor;

public interface UsuarioRepository {
    Iterable<Vendedor> findVendedoresByIdUsuario(Integer usuarioId);

}
