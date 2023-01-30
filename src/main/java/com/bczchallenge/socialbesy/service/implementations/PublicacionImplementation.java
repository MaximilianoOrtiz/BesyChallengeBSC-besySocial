package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.models.Publicacion;
import com.bczchallenge.socialbesy.service.interfaces.PublicacionInterface;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PublicacionImplementation implements PublicacionInterface {
    @Override
    public Integer publicar(Publicacion publicacion) {
        return null;

    }

    @Override
    public Collection<Publicacion> listado(Integer userId) {
        return null;

    }

    @Override
    public Publicacion promocion(Publicacion publicacion) {
        return null;

    }
}
