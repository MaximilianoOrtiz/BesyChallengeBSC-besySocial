package com.bczchallenge.socialbesy.repository;

import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface SeguidorRepository extends CrudRepository<Seguidor, Integer> {

    //@Query("select c.vendedores from Comprador c where c.id = ?1")
    @Query("select s.seguidos from Seguidor s where s.id=?1")
    Iterable<Usuario> findSeguidosByIdSeguidor(Integer seguidorId);

    @Query("select s from Seguidor s")
    Iterable<Seguidor> findAll();

    @Query("SELECT s.seguidos from Seguidor s inner join s.seguidos u where s.id = ?1 order by u.nombreDeUsuario asc")
    Iterable<Usuario> findSeguidosByIdSeguidorOrderByName(Integer seguidorId);

}

