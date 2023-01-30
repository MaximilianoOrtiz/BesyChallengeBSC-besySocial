package com.bczchallenge.socialbesy.repository;


import com.bczchallenge.socialbesy.domain.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

//@Repository("usuarioRepository")
//@Primary
@NoRepositoryBean
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Override
    Optional<Usuario> findById(Integer integer);
}
