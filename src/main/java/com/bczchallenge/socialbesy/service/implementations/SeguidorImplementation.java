
package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.mapper.UsuarioMapper;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.repository.SeguidorRepository;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.service.interfaces.SeguidorInterfaces;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class SeguidorImplementation implements SeguidorInterfaces {

    private final SeguidorRepository repository;

    private final UsuarioMapper usuarioMapper;

    @Override
    @Transactional(readOnly = true)
    public Iterable<UsuarioDTO> getSeguidos(Integer seguidorId) {
        log.info("INICIO --> getSeguidos("+seguidorId+")");
        Iterable<Usuario>seguidos= repository.findSeguidosByIdSeguidor(seguidorId);
        List<UsuarioDTO> seguidosDto= new ArrayList<UsuarioDTO>();
        seguidos.forEach(usu -> seguidosDto.add(usuarioMapper.mapUsuario(usu)));
        log.info("FIN --> getSeguidos("+seguidorId+")");
        return seguidosDto;
    }


}

