package com.bczchallenge.socialbesy.repository;


import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.domain.models.Vendedor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

//@Repository("usuarioRepository")
//@Primary
@NoRepositoryBean
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query(value = "select u from Usuario where u.id = ?1")
    Iterable<Usuario> findSeguidosByIdUsuario(Integer usuarioId);
}
