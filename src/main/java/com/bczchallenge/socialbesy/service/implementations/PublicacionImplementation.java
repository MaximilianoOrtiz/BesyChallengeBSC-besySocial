package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.dto.*;
import com.bczchallenge.socialbesy.domain.mapper.PublicacionProductoMapper;
import com.bczchallenge.socialbesy.domain.mapper.PublicacionRequesMapper;
import com.bczchallenge.socialbesy.domain.models.Producto;
import com.bczchallenge.socialbesy.domain.models.Publicacion;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.exception.CustomException;
import com.bczchallenge.socialbesy.repository.ProductoRepository;
import com.bczchallenge.socialbesy.repository.PublicacionRepository;
import com.bczchallenge.socialbesy.repository.UsuarioRepository;
import com.bczchallenge.socialbesy.service.interfaces.PublicacionInterface;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublicacionImplementation implements PublicacionInterface {

    private final PublicacionRepository publicacionRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PublicacionRequesMapper publicacionRequesMapper;
    private final PublicacionProductoMapper  publicacionProductoMapper;

    @Override
    public PublicacionProductoDTO publicar(PublicacionRequestDTO publicacionDTO) throws CustomException.ImplementationCustomExceptions {
        log.info("INICIO --> publicar("+publicacionDTO.getUserID()+")");
        log.info("Publicacion Request DTO: --> " + publicacionDTO.toString());
        PublicacionProductoDTO response = null;
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(publicacionDTO.getUserID());
            if(!usuario.isPresent()) return null;
            log.info("Usuario Encontrado: --> " + usuario.get().getNombreDeUsuario());
            Producto producto = publicacionRequesMapper.productorMapper(publicacionDTO);
            log.info("Producto Mapeado: --> " +producto.toString());
            Producto productoSave = productoRepository.save(producto);
            log.info("Producto Guardado: --> " +productoSave.toString());

            Publicacion publicacion = publicacionRequesMapper.publicacionMapper(publicacionDTO);
            log.info("Publicacion Mapeada: --> " +publicacion.toString());

            publicacion.setProducto(productoSave);
            publicacion.setUsuario(usuario.get());
            log.info("Publicacion con Producto: --> " +publicacion.toString());

            Publicacion publicacionSave = publicacionRepository.save(publicacion);
            log.info("Publicacion guardada: ---> " + publicacionSave.toString());

            log.info("Empiezo guardando publicaciones en usuarios");
            usuario.get().getPublicaciones().add(publicacionSave);
            Usuario usuarioDB = usuarioRepository.save(usuario.get());
            log.info("Guardo usuario en base" + usuarioDB.toString());

            response = publicacionProductoMapper.mapPublicacion(publicacionSave);
            log.info("Response: --> " + response.toString());
        }catch (Exception e){
            throw new CustomException.ImplementationCustomExceptions("ERROR---> publicar("+publicacionDTO.getUserID()+",): ",e.getCause());
        }
        log.info("FIN --> publicar("+publicacionDTO.getUserID()+")");
        return response;
    }

    @Override
    public Collection<Publicacion> listado(Integer userId) {
        return null;

    }

    @Override
    public Publicacion promocion(Publicacion publicacion) {
        return null;

    }
}
