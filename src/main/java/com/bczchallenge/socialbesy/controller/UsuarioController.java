package com.bczchallenge.socialbesy.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping("/{userID}/seguir/{userIDASeguir}")
    ResponseEntity seguir(@PathVariable("userID") Integer userID, @PathVariable("userIDASeguir")Integer userIDASeguir){
        return null;
    }
    @GetMapping("/{userID}/seguidores/listado")
    ResponseEntity quienMeSigue(@PathVariable(value= "id") Integer id){
        return null;
    }
    @GetMapping("/{userID}/seguidores/listado?ordenar=?&desc=?")
    ResponseEntity quienMeSigue(@PathVariable("idUser") Integer idUser, @PathVariable("ordenar") String ordenar, @PathVariable("desc")String desc){
        return null;
    }
    @GetMapping("/{userID}/sigo/listado?ordenar=?&desc=?")
    ResponseEntity aQuienSigo(@PathVariable("idUser") Integer idUser, @PathVariable("ordenar") String ordenar, @PathVariable("desc")String desc){
        return null;
    }
    @GetMapping("/{userID}/sigo/listado")
    ResponseEntity aQuienSigo(@PathVariable(value= "id") Integer id){
        return null;
    }
}
