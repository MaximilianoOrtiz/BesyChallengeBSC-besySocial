
package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.repository.SeguidorRepository;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.service.interfaces.SeguidorInterfaces;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Slf4j
@Service
public class SeguidorImplementation implements SeguidorInterfaces {

    @Autowired
    private SeguidorRepository repository;


    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> getSeguidos(Integer seguidorId) {
        log.info("Metodo getSeguidos("+seguidorId+")");
        Iterable<Usuario>seguidos= repository.findSeguidosByIdSeguidor(seguidorId);
        return null;
    }


}

