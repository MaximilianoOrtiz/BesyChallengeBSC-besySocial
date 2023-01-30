package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.domain.models.Vendedor;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import com.bczchallenge.socialbesy.service.interfaces.VendedorInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class UsuarioImplementation implements UsuarioInterface {

    @Qualifier("usuarioRepository")
    @Autowired
    private  UsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> getSeguidos(Integer usuarioId) {
        log.info("Metodo getSeguidos("+usuarioId+")");
        return repository.findSeguidosByIdUsuario(usuarioId);
    }
}
