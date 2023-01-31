package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.dto.UsuarioSiguiendoDTO;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.exception.CustomException;

public interface UsuarioInterface {
    UsuarioDTO getListadosSeguidores(Integer idVendedor) throws CustomException.ImplementationCustomExceptions;

    UsuarioSiguiendoDTO seguir(Integer userId, Integer userIdSeguir) throws CustomException.ImplementationCustomExceptions;


}
