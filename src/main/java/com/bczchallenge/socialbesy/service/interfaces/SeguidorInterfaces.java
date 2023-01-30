package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.models.Usuario;

public interface SeguidorInterfaces{

    public Iterable<Usuario> getSeguidos(Integer compradorId);
}
