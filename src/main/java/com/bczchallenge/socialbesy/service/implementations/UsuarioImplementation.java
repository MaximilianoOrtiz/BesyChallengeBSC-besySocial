package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.dto.SeguidorDTO;
import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.mapper.SeguidorMapper;
import com.bczchallenge.socialbesy.domain.mapper.UsuarioMapper;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.repository.SeguidorRepository;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

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
    public UsuarioDTO getListadosSeguidores(Integer idUsuario) {
        log.info("INICIO --> getListaSeguidores("+idUsuario+")");
        UsuarioDTO usuarioDTO= null;
        Optional<Usuario> usuario= repository.findById(idUsuario);
        if(usuario.isPresent()) {
            log.info(String.valueOf(usuario.get()));
            usuarioDTO= usuarioMapper.mapUsuario(usuario.get());
            List<SeguidorDTO> seguidoresDTO = new ArrayList<SeguidorDTO>();
            Iterable<Seguidor> seguidores = repository.findSeguidoresByIdUsuarios(idUsuario);
            seguidores.forEach(seguidor -> seguidoresDTO.add(seguidorMapper.mapSeguidor(seguidor)));
            usuarioDTO.setSeguidores(seguidoresDTO);
        }
        log.info("FIN --> getListaSeguidores("+idUsuario+")");
        return usuarioDTO;
    }
}
