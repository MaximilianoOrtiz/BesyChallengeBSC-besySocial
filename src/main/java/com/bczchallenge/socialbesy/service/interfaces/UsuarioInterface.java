package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.dto.UsuarioSiguiendoDTO;
import com.bczchallenge.socialbesy.exception.CustomException;

public interface UsuarioInterface {
    UsuarioDTO getListadosSeguidores(Integer idVendedor) throws CustomException.ImplementationCustomExceptions;
    UsuarioDTO getListadosSeguidores(Integer seguidorId, String ordenar, String desc) throws CustomException.ImplementationCustomExceptions;
    UsuarioSiguiendoDTO seguir(Integer userId, Integer userIdSeguir) throws CustomException.ImplementationCustomExceptions;

}
