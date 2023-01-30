package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.dto.SeguidorDTO;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;

public interface UsuarioInterface {
    Iterable<SeguidorDTO> getListadosSeguidores(Integer idVendedor);
}
