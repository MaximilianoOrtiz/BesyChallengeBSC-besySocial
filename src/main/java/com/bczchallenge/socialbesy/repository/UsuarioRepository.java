package com.bczchallenge.socialbesy.repository;


import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.domain.models.Vendedor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository("usuarioRepository")
//@Primary
@NoRepositoryBean
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Override
    Optional<Usuario> findById(Integer integer);
}
