package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.models.Comprador;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.domain.models.Vendedor;
import com.bczchallenge.socialbesy.repository.CompradorRepository;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.service.interfaces.CompradorInterfaces;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Slf4j
@Service
public class CompradorImplementation implements CompradorInterfaces {

    @Autowired
    @Qualifier("compradorRepository")
    private UsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> getSeguidos(Integer compradorId) {
        log.info("Metodo getSeguidos("+compradorId+")");
        return ((CompradorRepository)repository).findSeguidosByIdComprador(compradorId);
    }


}
