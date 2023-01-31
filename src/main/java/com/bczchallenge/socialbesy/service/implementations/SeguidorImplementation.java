
package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.dto.DTOSeguidor;
import com.bczchallenge.socialbesy.domain.dto.DTOSiguiendo;
import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.mapper.SeguidorMapper;
import com.bczchallenge.socialbesy.domain.mapper.UsuarioMapper;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.exception.CustomException;
import com.bczchallenge.socialbesy.repository.SeguidorRepository;
import com.bczchallenge.socialbesy.service.interfaces.SeguidorInterfaces;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class SeguidorImplementation implements SeguidorInterfaces {

    private final SeguidorRepository repository;

    private final UsuarioMapper usuarioMapper;
    private final SeguidorMapper seguidorMapper;

    @Override
    @Transactional(readOnly = true)
    public DTOSeguidor getSeguidos(Integer seguidorId) throws CustomException.ImplementationCustomExceptions {
        log.info("INICIO --> getSeguidos("+seguidorId+")");
        DTOSeguidor response = null;
        try {
            Optional<Seguidor> seguidor = repository.findById(seguidorId);
            log.info("Existe seguidor: "+String.valueOf(seguidor.isPresent()));
            if (seguidor.isPresent()) {
                response= seguidorMapper.mapSeguidor(seguidor.get());
                List<DTOSiguiendo> seguidosDto = new ArrayList<>();
                log.info("busco seguidos");
                Iterable<Usuario> seguidos = repository.findSeguidosByIdSeguidor(seguidorId);
                log.info("resultado busqueda"+ (seguidos != null));
                log.info("inicio mapeo");
                seguidos.forEach(usu -> seguidosDto.add(usuarioMapper.mapSeguidor(usu)));
                log.info("resultado mappeo"+ (seguidosDto != null));
                response.setSeguidos(seguidosDto);
                log.info("FIN --> getSeguidos(). response: " + (seguidosDto.get(0).getNombre_Seguido()));
            }
        }catch (Exception e){
            throw new CustomException.ImplementationCustomExceptions("ERROR ---> getSeguidos("+seguidorId+")",e.getCause());
        }
        return response;
    }


}

