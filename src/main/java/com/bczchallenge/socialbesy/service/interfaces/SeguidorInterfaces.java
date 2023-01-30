package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.models.Usuario;

public interface SeguidorInterfaces{

    public Iterable<UsuarioDTO> getSeguidos(Integer compradorId);
}
