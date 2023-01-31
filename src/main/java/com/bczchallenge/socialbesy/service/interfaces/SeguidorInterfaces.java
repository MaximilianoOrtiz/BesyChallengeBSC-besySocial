package com.bczchallenge.socialbesy.service.interfaces;

import com.bczchallenge.socialbesy.domain.dto.DTOSeguidor;
import com.bczchallenge.socialbesy.exception.CustomException;
import org.springframework.web.bind.annotation.PathVariable;

public interface SeguidorInterfaces{

    DTOSeguidor getSeguidos(Integer seguidorId) throws CustomException.ImplementationCustomExceptions;
    DTOSeguidor getSeguidos(Integer seguidorId,String ordenar,String desc) throws CustomException.ImplementationCustomExceptions;


}
