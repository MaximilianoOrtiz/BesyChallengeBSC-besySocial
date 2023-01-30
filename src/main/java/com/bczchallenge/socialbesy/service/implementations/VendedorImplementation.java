package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.repository.VendedorRepository;
import com.bczchallenge.socialbesy.service.interfaces.VendedorInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class VendedorImplementation implements VendedorInterface {

    @Qualifier("vendedorRepository")
    private final UsuarioRepository repository;

    @Override
    public Iterable<Usuario> getListadosSeguidores(Integer idVendedor) {
        return ((VendedorRepository)repository).findSeguidoresByIdVendedor(idVendedor);

    }
}
