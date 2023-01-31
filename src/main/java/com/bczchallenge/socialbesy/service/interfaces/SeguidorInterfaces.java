package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.dto.DTOSeguidor;
import com.bczchallenge.socialbesy.exception.CustomException;

public interface SeguidorInterfaces{

    public DTOSeguidor getSeguidos(Integer compradorId) throws CustomException.ImplementationCustomExceptions;
}
