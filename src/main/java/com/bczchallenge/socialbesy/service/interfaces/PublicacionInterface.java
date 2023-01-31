package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.dto.PublicacionProductoDTO;
import com.bczchallenge.socialbesy.domain.dto.PublicacionRequestDTO;
import com.bczchallenge.socialbesy.domain.models.Publicacion;
import com.bczchallenge.socialbesy.exception.CustomException;

import java.util.Collection;

public interface PublicacionInterface {
    PublicacionProductoDTO publicar(PublicacionRequestDTO publicacion) throws CustomException.ImplementationCustomExceptions;

    Collection<Publicacion> listado(Integer userId);

    Publicacion promocion(Publicacion publicacion);
}
