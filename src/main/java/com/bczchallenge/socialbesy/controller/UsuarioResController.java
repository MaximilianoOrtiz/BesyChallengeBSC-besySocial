package com.bczchallenge.socialbesy.controller;

import com.bczchallenge.socialbesy.domain.dto.CompradorDTO;
import com.bczchallenge.socialbesy.domain.models.Seguidor;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
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
@RequestMapping("/usuarios")
public class UsuarioResController {

    @Autowired(required = true)
    private UsuarioInterface usuarioServices;


    @GetMapping("/{userID}/seguidores/listado")
    ResponseEntity quienMeSigue(@PathVariable(value= "userID") Integer userID){
        try{
            log.info("Inicio metodo quienMeSigue ("+userID+")");
            Map<String, Object> mensaje= new HashMap<String, Object>();

            List<Seguidor> data = (List<Seguidor>) usuarioServices.getListadosSeguidores(userID);//TODO LLAMADA A LA IMPLEMENTACION;
            //List<CompradorDTO> dtos = new ArrayList<>();
            //data.forEach(usuario -> dtos.add(mapper.mapComprador((Comprador)usuario)));

            log.info(String.valueOf((data != null)));
            log.info(String.valueOf(data.get(0).getNombreDeUsuario()));

            // data.forEach(usuario -> log.info(((Comprador)usuario).toString()));
            mensaje.put("Success", true);
            mensaje.put("Data", data);

            return ResponseEntity.ok(mensaje);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
