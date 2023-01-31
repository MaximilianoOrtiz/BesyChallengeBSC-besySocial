package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.dto.DTOQuienMeSigue;
import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.dto.UsuarioSiguiendoDTO;
import com.bczchallenge.socialbesy.domain.mapper.SeguidorMapper;
import com.bczchallenge.socialbesy.domain.mapper.UsuarioMapper;
import com.bczchallenge.socialbesy.domain.mapper.UsuarioSiguiendoMapper;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.exception.CustomException;
import com.bczchallenge.socialbesy.repository.SeguidorRepository;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioImplementation implements UsuarioInterface {

    private final UsuarioRepository repository;
    private final SeguidorRepository seguidorRepository;
    private final SeguidorMapper seguidorMapper;
    private final UsuarioMapper usuarioMapper;

    private  final UsuarioSiguiendoMapper usuarioSiguiendoMapper;

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
               seguidores.forEach(seguidor -> seguidoresDTO.add(seguidorMapper.mapQuienMeSigue(seguidor)));
               usuarioDTO.setSeguidores(seguidoresDTO);
           }
       }catch (Exception e){
           throw new CustomException.ImplementationCustomExceptions("ERROR---> getListadoSeguidores("+idUsuario.toString()+"): ",e.getCause());
       }
        log.info("FIN --> getListaSeguidores("+idUsuario+"). response:"+ usuarioDTO);
        return usuarioDTO;
    }

    @Override
    public UsuarioSiguiendoDTO seguir(Integer userId, Integer userIdSeguir) throws CustomException.ImplementationCustomExceptions {
        log.info("INICIO --> seguir.  Usuario:  ("+userId+"). sigue: " + userIdSeguir);
        UsuarioSiguiendoDTO usuarioSiguiendoDTO = null;
        try {
            Optional<Usuario> usuario = repository.findById(userId);
            Optional<Usuario> usuarioASeguir = repository.findById(userIdSeguir);
            if (!usuario.isPresent()) return null;
            if(!usuarioASeguir.isPresent()) return null;
            Usuario usuarioSave = usuario.get();
            Seguidor seguidor = new Seguidor();
            seguidor.setId(userIdSeguir);
            seguidor.setNombreDeSeguidor(usuarioASeguir.get().getNombreDeUsuario());
            usuarioSave.insertarNuevoSeguidor(seguidor);
            repository.save(usuarioSave);
            usuarioSiguiendoDTO = usuarioSiguiendoMapper.mapUsuario(usuarioSave);
            DTOQuienMeSigue siguiendo = seguidorMapper.mapQuienMeSigue(seguidor);
            usuarioSiguiendoDTO.setSigue(siguiendo);
        }
        catch (Exception e){
            throw new CustomException.ImplementationCustomExceptions("ERROR---> seguir("+userId.toString()+","+userIdSeguir+"): ",e.getCause());
        }
        log.info("FIN --> seguir.  Usuario:  ("+userId+"). sigue: " + userIdSeguir);
        return  usuarioSiguiendoDTO;
    }
}
