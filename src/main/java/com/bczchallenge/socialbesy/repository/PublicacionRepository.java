package com.bczchallenge.socialbesy.repository;

import com.bczchallenge.socialbesy.domain.models.Publicacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PublicacionRepository  extends CrudRepository<Publicacion, Integer>{

    @Query("select p from Publicacion p where p.usuario.id = ?1")
    Iterable<Publicacion> findAllByUsuario(Integer userId);
}
