
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

import java.util.*;
import java.util.stream.Collectors;


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

    @Override
    public DTOSeguidor getSeguidos(Integer seguidorId, String ordenar, String desc) throws CustomException.ImplementationCustomExceptions {
        log.info("INICIO --> getSeguidos("+seguidorId+")");
        DTOSeguidor response = null;
        try {
            Optional<Seguidor> seguidor;
            seguidor = repository.findById(seguidorId);
            log.info("Existe seguidor: "+String.valueOf(seguidor.isPresent()));
            if (seguidor.isPresent()) {
                response= seguidorMapper.mapSeguidor(seguidor.get());
                List<DTOSiguiendo> seguidosDto = new ArrayList<>();
                Iterable<Usuario> seguidos;
                if(ordenar.equalsIgnoreCase("nombre") ){
                    log.info("busco seguidos ordenados por nombre");
                    seguidos = repository.findSeguidosByIdSeguidorOrderByName(seguidorId);
                    log.info("resultado busqueda"+ (seguidos != null));
                }else {
                    log.info("busco seguidos sin ordenar");
                    seguidos = repository.findSeguidosByIdSeguidor(seguidorId);
                    log.info("resultado busqueda" + (seguidos != null));
                }
                log.info("inicio mapeo"+ (seguidosDto != null));
                log.info("Cantidad de usuarios seguidos antes del distinc: "+ ((List<Usuario>)seguidos).size());
                seguidos= ((List<Usuario>)seguidos).stream().distinct().collect(Collectors.toList());
                log.info("Cantidad de usuarios seguidos despues del distinc: "+ ((List<Usuario>)seguidos).size());
                seguidos.forEach(usu -> seguidosDto.add(usuarioMapper.mapSeguidor(usu)));
                log.info("resultado mappeo"+ (seguidosDto != null));
                log.info("Cantidad de usuarios mappeados: "+seguidosDto.size() );
                if(desc.equalsIgnoreCase("desc")){
                    log.info("ordeno la busqueda de forma desc");
                    Collections.reverse(seguidosDto);
                }

                response.setSeguidos(null);
                log.info("Lista de seguidos vacia: "+ (response.getSeguidos() == null) );
                response.setSeguidos(seguidosDto);
                log.info("FIN --> getSeguidos(). response: " + (seguidosDto.get(0).getNombre_Seguido()));
            }
        }catch (Exception e){
            throw new CustomException.ImplementationCustomExceptions("ERROR ---> getSeguidos("+seguidorId+")",e.getCause());
        }
        return response;
    }


}

