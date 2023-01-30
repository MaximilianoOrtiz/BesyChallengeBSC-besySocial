package com.bczchallenge.socialbesy.repository;

import com.bczchallenge.socialbesy.domain.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("compradorRepository")
public interface CompradorRepository extends UsuarioRepository{

    @Query("select c.vendedores from Comprador c where c.id = ?1")
    Iterable<Usuario> findSeguidosByIdComprador(Integer compradorId);


}
