package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class UsuarioImplementation implements UsuarioInterface {

    private final UsuarioRepository repository;

    public UsuarioImplementation(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Seguidor> getListadosSeguidores(Integer idUsuario) {
        return repository.findSeguidoresByIdUsuarios(idUsuario);
    }
}
