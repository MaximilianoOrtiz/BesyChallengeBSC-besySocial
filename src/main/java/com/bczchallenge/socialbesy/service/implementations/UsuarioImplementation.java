package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.dto.DTOQuienMeSigue;
import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.mapper.SeguidorMapper;
import com.bczchallenge.socialbesy.domain.mapper.UsuarioMapper;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.exception.CustomException;
import com.bczchallenge.socialbesy.repository.SeguidorRepository;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioImplementation implements UsuarioInterface {

    private final UsuarioRepository repository;
    private final SeguidorMapper seguidorMapper;
    private final SeguidorRepository seguidorRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO getListadosSeguidores(Integer idUsuario) throws CustomException.ImplementationCustomExceptions {
        log.info("INICIO --> getListaSeguidores("+idUsuario+")");
        UsuarioDTO usuarioDTO = null;
        try {
           Optional<Usuario> usuario = repository.findById(idUsuario);
           if (usuario.isPresent()) {
               log.info(String.valueOf(usuario.get()));
               usuarioDTO = usuarioMapper.mapUsuario(usuario.get());
               List<DTOQuienMeSigue> seguidoresDTO = new ArrayList<DTOQuienMeSigue>();
               Iterable<Seguidor> seguidores = repository.findSeguidoresByIdUsuarios(idUsuario);
               seguidores.forEach(seguidor -> seguidoresDTO.add(seguidorMapper.mapSeguidor(seguidor)));
               usuarioDTO.setSeguidores(seguidoresDTO);
           }
       }catch (Exception e){
           throw new CustomException.ImplementationCustomExceptions(e.getCause());
       }
        log.info("FIN --> getListaSeguidores("+idUsuario+"). response:"+ usuarioDTO);
        return usuarioDTO;
    }
}
