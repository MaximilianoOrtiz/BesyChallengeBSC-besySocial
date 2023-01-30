/*
package com.bczchallenge.socialbesy.controller;

import com.bczchallenge.socialbesy.domain.dto.SeguidorDTO;
//import com.bczchallenge.socialbesy.domain.models.Comprador;
import com.bczchallenge.socialbesy.domain.models.Usuario;
import com.bczchallenge.socialbesy.service.interfaces.CompradorInterfaces;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired(required = true)
    private CompradorInterfaces usuarioServices;

    @PostMapping("/{userID}/seguir/{userIDASeguir}")
    ResponseEntity seguir(@PathVariable("userID") Integer userID, @PathVariable("userIDASeguir")Integer userIDASeguir){
        try{
            Map<String, Object> mensaje= new HashMap<String, Object>();

            Integer data= null;//TODO LLAMADA A LA IMPLEMENTACION;
            mensaje.put("Success", true);
            mensaje.put("Data", data);

            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{userID}/seguidores/listado")
    ResponseEntity quienMeSigue(@PathVariable(value= "userID") Integer userID){
        try{
            log.info("Inicio metodo quienMeSigue ("+userID+")");
            Map<String, Object> mensaje= new HashMap<String, Object>();

            List<Usuario> data = (List<Usuario>) usuarioServices.getSeguidos(userID);//TODO LLAMADA A LA IMPLEMENTACION;
            List<SeguidorDTO> dtos = new ArrayList<>();
            //data.forEach(usuario -> dtos.add(mapper.mapComprador((Comprador)usuario)));

            log.info(String.valueOf((data != null)));
            log.info(String.valueOf(data.size()));
           // data.forEach(usuario -> log.info(((Comprador)usuario).toString()));
            mensaje.put("Success", true);
            mensaje.put("Data", data);

            return ResponseEntity.ok(mensaje);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{userID}/seguidores/listado?ordenar=?&desc=?")
    ResponseEntity quienMeSigue(@PathVariable("idUser") Integer idUser, @PathVariable("ordenar") String ordenar, @PathVariable("desc")String desc){
        try{
            Map<String, Object> mensaje= new HashMap<String, Object>();

            Integer data= null;//TODO LLAMADA A LA IMPLEMENTACION;
            mensaje.put("Success", true);
            mensaje.put("Data", data);

            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{userID}/sigo/listado?ordenar=?&desc=?")
    ResponseEntity aQuienSigo(@PathVariable("idUser") Integer idUser, @PathVariable("ordenar") String ordenar, @PathVariable("desc")String desc){
        try{
            Map<String, Object> mensaje= new HashMap<String, Object>();

            Integer data= null;//TODO LLAMADA A LA IMPLEMENTACION;
            mensaje.put("Success", true);
            mensaje.put("Data", data);

            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{userID}/sigo/listado")
    ResponseEntity aQuienSigo(@PathVariable(value= "id") Integer id){
        try{
            Map<String, Object> mensaje= new HashMap<String, Object>();

            Integer data= null;//TODO LLAMADA A LA IMPLEMENTACION;
            mensaje.put("Success", true);
            mensaje.put("Data", data);

            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
*/
