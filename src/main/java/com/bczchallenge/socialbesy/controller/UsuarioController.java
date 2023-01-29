package com.bczchallenge.socialbesy.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

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
    ResponseEntity quienMeSigue(@PathVariable(value= "id") Integer id){
        try{
            Map<String, Object> mensaje= new HashMap<String, Object>();

            Integer data= null;//TODO LLAMADA A LA IMPLEMENTACION;
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
