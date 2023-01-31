package com.bczchallenge.socialbesy.controller;

import com.bczchallenge.socialbesy.domain.dto.DTOSeguidor;
import com.bczchallenge.socialbesy.domain.dto.DTOSiguiendo;
import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.dto.UsuarioSiguiendoDTO;
import com.bczchallenge.socialbesy.service.interfaces.SeguidorInterfaces;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioRestController {


    private final UsuarioInterface usuarioServices;
    private final SeguidorInterfaces seguidorService;


    @PostMapping("/{userID}/seguir/{userIDASeguir}")
    ResponseEntity seguir(@PathVariable("userID") Integer userID, @PathVariable("userIDASeguir")Integer userIDASeguir){
        try{
            Map<String, Object> mensaje= new HashMap<String, Object>();

            UsuarioSiguiendoDTO data= usuarioServices.seguir(userID,userIDASeguir);//TODO LLAMADA A LA IMPLEMENTACION;
            mensaje.put("Success", true);
            mensaje.put("Data", data);

            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/{userID}/seguidores/listado")
    ResponseEntity quienMeSigue(@PathVariable(value= "userID") Integer userID){
        Map<String, Object> mensaje= new HashMap<String, Object>();
        try{
            log.info("Inicio metodo quienMeSigue ("+userID+")");
            UsuarioDTO data = usuarioServices.getListadosSeguidores(userID);//TODO LLAMADA A LA IMPLEMENTACION;
            //List<CompradorDTO> dtos = new ArrayList<>();
            //data.forEach(usuario -> dtos.add(mapper.mapComprador((Comprador)usuario)));

            log.info(String.valueOf((data != null)));
            //log.info(String.valueOf(data.get(0).getNombre_Usuario()));

            // data.forEach(usuario -> log.info(((Comprador)usuario).toString()));
            mensaje.put("Success", true);
            mensaje.put("Data", data);

        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{userID}/sigo/listado")
    ResponseEntity aQuienSigo(@PathVariable(value= "userID") Integer userID){
        try{
            Map<String, Object> mensaje= new HashMap<String, Object>();

            DTOSeguidor data = seguidorService.getSeguidos(userID);//TODO LLAMADA A LA IMPLEMENTACION;
            mensaje.put("Success", true);
            mensaje.put("Data", data);
            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
/*
    @GetMapping("/{userID}/sigo/listado?ordenar=?&desc=?")
    ResponseEntity aQuienSigo(@PathVariable("idUser") Integer idUser, @PathVariable("ordenar") String ordenar, @PathVariable("desc")String desc){
        Map<String, Object> mensaje= new HashMap<String, Object>();
        try{
            DTOSeguidor data=  seguidorService.getSeguidos(idUser);//TODO LLAMADA A LA IMPLEMENTACION;
            mensaje.put("Success", true);
            mensaje.put("Data", data);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(mensaje);
    }

 */
}
