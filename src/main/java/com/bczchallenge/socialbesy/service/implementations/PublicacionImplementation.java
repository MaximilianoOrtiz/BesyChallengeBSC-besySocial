package com.bczchallenge.socialbesy.service.implementations;

import com.bczchallenge.socialbesy.domain.dto.*;
import com.bczchallenge.socialbesy.domain.mapper.PromocioProductoMapper;
import com.bczchallenge.socialbesy.domain.mapper.PublicacionMapper;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublicacionImplementation implements PublicacionInterface {

    private final PublicacionRepository publicacionRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PublicacionRequesMapper publicacionRequesMapper;
    private final PublicacionProductoMapper  publicacionProductoMapper;
    private final PublicacionMapper publicacionMapper;
    private final PromocioProductoMapper promocioProductoMapper;

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
    public DTOPublicacionResponse listado(Integer userId) throws CustomException.ImplementationCustomExceptions {
        log.info("INICIO --> listado("+userId+")");
        DTOPublicacionResponse response= new DTOPublicacionResponse();
        try{
            Optional<Usuario> usuario= usuarioRepository.findById(userId);
            log.info("Usuario encontrado: "+ usuario.isPresent());
            if(usuario.isPresent()){
                List<Publicacion> publicaciones= (List<Publicacion>) publicacionRepository.findAllByUsuario(userId);
                log.info("publicaciones sin filtrar: "+publicaciones.size());
                publicaciones.stream().filter(pub -> dateDiff(pub.getFechaAlta()) > 7)
                        .collect(Collectors.toList());
                log.info("publicaciones filtradas: "+publicaciones.size());List<DTOPublicacionSinPromo> dtoPublicacionesSinPromo = new ArrayList<>();
                publicaciones.forEach(publicacion -> dtoPublicacionesSinPromo.add(publicacionMapper.mapPublicacionSinPromo(publicacion)));
//              response.setUser_id(userId);
                response.setPublicaciones(dtoPublicacionesSinPromo);
            }
        }catch (Exception e){
            throw new CustomException.ImplementationCustomExceptions("ERROR ---> listado("+userId+")",e.getCause());
        }
        log.info("INICIO --> listado()");
        return response;
    }

    @Override
    public DTOPromocionResponse promocion(Integer userId) throws CustomException.ImplementationCustomExceptions {
        log.info("INICIO --> listado("+userId+")");
        DTOPromocionResponse response= new DTOPromocionResponse();
        try{
            Optional<Usuario> usuario= usuarioRepository.findById(userId);
            log.info("Usuario encontrado: "+ usuario.isPresent());
            if(usuario.isPresent()){
                List<Publicacion> publicaciones= (List<Publicacion>) publicacionRepository.findPromocionesByIdUsuario(userId);
                log.info("publicaciones sin filtrar: "+publicaciones.size());
                publicaciones.stream().filter(pub -> dateDiff(pub.getFechaAlta()) > 7)
                        .collect(Collectors.toList());
                log.info("publicaciones filtradas: "+publicaciones.size());
                List<DTOPublicacionPromocion> dtoPublicacionesPromo = new ArrayList<>();
                publicaciones.forEach(publicacion -> dtoPublicacionesPromo.add(publicacionMapper.mapPublicacionPromo(publicacion)));
                response.setUser_id(userId);
                response.setPublicaciones(dtoPublicacionesPromo);
            }
        }catch (Exception e){
            throw new CustomException.ImplementationCustomExceptions("ERROR ---> listado("+userId+")",e.getCause());
        }
        log.info("INICIO --> listado()");
        return response;
    }


    @Override
    public DTOPromocioProducto publicarPromocion(PublicacionRequestDTO publicacionDTO) throws CustomException.ImplementationCustomExceptions { log.info("INICIO --> publicar("+publicacionDTO.getUserID()+")");
        log.info("INICIO --> publicarPromocion ("+publicacionDTO.getUserID()+")");
        log.info("Publicacion Request DTO: --> " + publicacionDTO.toString());
        DTOPromocioProducto response = null;
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(publicacionDTO.getUserID());
            if(!usuario.isPresent()) return null;
            log.info("Usuario Encontrado: --> " + usuario.get().getNombreDeUsuario());
            Producto producto = publicacionRequesMapper.productorMapper(publicacionDTO);
            log.info("Producto Mapeado: --> " +producto.toString());
            Producto productoSave = productoRepository.save(producto);
            log.info("Producto Guardado: --> " +productoSave.toString());

            Publicacion publicacion = publicacionRequesMapper.promocionMapper(publicacionDTO);
            log.info("Promocion Mapeada: --> " +publicacion.toString());
            log.info("Calculando nuevo precio ");
            Double precioDescuento =  (publicacionDTO.getPrecio() - (publicacionDTO.getPrecio()*(publicacionDTO.getDescuento()/100)));
            log.info("nuevo precio: --> " + precioDescuento );
            publicacion.setProducto(productoSave);
            publicacion.setUsuario(usuario.get());
            publicacion.setPrecioDescuento(precioDescuento);
            log.info("Publicacion con Producto: --> " +publicacion.toString());
            Publicacion publicacionSave = publicacionRepository.save(publicacion);
            log.info("Publicacion guardada: ---> " + publicacionSave.toString());

            log.info("Empiezo guardando publicaciones en usuarios");
            usuario.get().getPublicaciones().add(publicacionSave);
            Usuario usuarioDB = usuarioRepository.save(usuario.get());
            log.info("Guardo usuario en base" + usuarioDB.toString());

            response = promocioProductoMapper.mapPromocio(publicacionSave);
            log.info("Response: --> " + response.toString());
        }catch (Exception e){
            throw new CustomException.ImplementationCustomExceptions("ERROR---> publicarPromocion("+publicacionDTO.getUserID()+",): ",e.getCause());
        }
        log.info("FIN --> publicarPromocion("+publicacionDTO.getUserID()+")");
        return response;
    }


    private int dateDiff(String fecha) {
        log.info("INICIO --> dateDiff("+fecha+")");
        int result= 0;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dfecha = format.parse(fecha);
            long today = new Date().getTime();
            long date = dfecha.getTime();
            long timeDiff = Math.abs(today - date);
            result= (int) (timeDiff/(1000*60*60*24));
        }catch (Exception e){
            log.info("Error --> dateDiff()"+ e.getMessage()+ e.getCause().toString());
        }
        log.info("FIN --> dateDiff(), result:"+ result);
        return result;
    }
}
