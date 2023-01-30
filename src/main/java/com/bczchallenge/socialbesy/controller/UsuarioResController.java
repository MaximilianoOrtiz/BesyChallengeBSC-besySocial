package com.bczchallenge.socialbesy.controller;

import com.bczchallenge.socialbesy.domain.dto.SeguidorDTO;
import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.mapper.SeguidorMapper;
import com.bczchallenge.socialbesy.domain.mapper.UsuarioMapper;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.service.interfaces.SeguidorInterfaces;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioResController {


    private final UsuarioInterface usuarioServices;
    private final SeguidorInterfaces seguidorService;



    @GetMapping("/{userID}/seguidores/listado")
    ResponseEntity quienMeSigue(@PathVariable(value= "userID") Integer userID){
        Map<String, Object> mensaje= new HashMap<String, Object>();
        try{
            log.info("Inicio metodo quienMeSigue ("+userID+")");
            List<SeguidorDTO> data = (List<SeguidorDTO>) usuarioServices.getListadosSeguidores(userID);//TODO LLAMADA A LA IMPLEMENTACION;
            //List<CompradorDTO> dtos = new ArrayList<>();
            //data.forEach(usuario -> dtos.add(mapper.mapComprador((Comprador)usuario)));

            log.info(String.valueOf((data != null)));
            log.info(String.valueOf(data.get(0).getNombre_Usuario()));

            // data.forEach(usuario -> log.info(((Comprador)usuario).toString()));
            mensaje.put("Success", true);
            mensaje.put("Data", data);

        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(mensaje);

    }

    @GetMapping("/{userID}/sigo/listado?ordenar=?&desc=?")
    ResponseEntity aQuienSigo(@PathVariable("idUser") Integer idUser, @PathVariable("ordenar") String ordenar, @PathVariable("desc")String desc){
        Map<String, Object> mensaje= new HashMap<String, Object>();
        try{
            List<UsuarioDTO> data= null;//TODO LLAMADA A LA IMPLEMENTACION;
            mensaje.put("Success", true);
            mensaje.put("Data", data);


        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(mensaje);
    }
}
