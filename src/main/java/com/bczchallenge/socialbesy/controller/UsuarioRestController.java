package com.bczchallenge.socialbesy.controller;

import com.bczchallenge.socialbesy.domain.dto.DTOSeguidor;
import com.bczchallenge.socialbesy.domain.dto.UsuarioDTO;
import com.bczchallenge.socialbesy.domain.dto.UsuarioSiguiendoDTO;
import com.bczchallenge.socialbesy.service.interfaces.SeguidorInterfaces;
import com.bczchallenge.socialbesy.service.interfaces.UsuarioInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        log.info("INICIO --> Seguir("+userID+","+userIDASeguir+")");
        Map<String, Object> mensaje= new HashMap<String, Object>();
        try{
            UsuarioSiguiendoDTO data= usuarioServices.seguir(userID,userIDASeguir);//TODO LLAMADA A LA IMPLEMENTACION;
            mensaje.put("Success", true);
            mensaje.put("Data", data);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        log.info("FIN --> seguir()"+ mensaje.get("Success"));
        return ResponseEntity.ok(mensaje);
    }


    @GetMapping("/{userID}/seguidores/listado")
    ResponseEntity quienMeSigue(@PathVariable(value= "userID") Integer userID){
        Map<String, Object> mensaje= new HashMap<String, Object>();
        try{
            log.info("INICIO --> quienMeSigue("+userID+")");
            UsuarioDTO data = usuarioServices.getListadosSeguidores(userID);
            mensaje.put("Success", true);
            mensaje.put("Data", data);

        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        log.info("FIN --> quienMeSigue()"+ mensaje.get("Success"));
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{userID}/sigo/listado")
    ResponseEntity aQuienSigo(@PathVariable(value= "userID") Integer userID){
        log.info("INICIO --> aQuienSigo("+userID+")");
        Map<String, Object> mensaje= new HashMap<String, Object>();
        try{
            DTOSeguidor data = seguidorService.getSeguidos(userID);
            mensaje.put("Success", true);
            mensaje.put("Data", data);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        log.info("FIN --> aQuienSigo()"+ mensaje.get("Success"));
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{userID}/sigo/listado?ordenar=?&desc=?")
    ResponseEntity aQuienSigoByFiltro(@PathVariable("userID") Integer userID, @RequestParam String ordenar, @RequestParam String desc){
        log.info("INICIO --> aQuienSigoByFiltro("+userID+","+ordenar+","+desc+")");
        Map<String, Object> mensaje= new HashMap<String, Object>();
        try{
            DTOSeguidor data=  seguidorService.getSeguidos(userID, ordenar, desc);
            mensaje.put("Success", true);
            mensaje.put("Data", data);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        log.info("FIN --> aQuienSigoByFiltro()"+ mensaje.get("Success"));
        return ResponseEntity.ok(mensaje);
    }
}
