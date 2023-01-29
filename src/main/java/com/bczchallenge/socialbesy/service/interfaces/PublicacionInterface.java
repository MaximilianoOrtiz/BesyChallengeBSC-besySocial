package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.models.Publicacion;

import java.util.Collection;

public interface PublicacionInterface {
    Integer publicar(Publicacion publicacion);

    Collection<Publicacion> listado(Integer userId);

    Publicacion promocion(Publicacion publicacion);
}
