package com.bczchallenge.socialbesy.repository;


import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

//@Repository("usuarioRepository")
//@Primary
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("select u.seguidores from Usuario u where u.id = ?1")
    Iterable<Seguidor> findSeguidoresByIdUsuarios(Integer idUsuario);

    @Query("SELECT u.seguidores from Usuario u inner join u.seguidores s where u.id = ?1 order by s.nombreDeSeguidor asc")
    Iterable<Seguidor> findSeguidoresByIdUsuarioOrderByName(Integer usuarioId);
}
