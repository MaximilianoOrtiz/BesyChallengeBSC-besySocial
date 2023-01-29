package com.bczchallenge.socialbesy.controller;

import com.bczchallenge.socialbesy.domain.models.Publicacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @PostMapping("/publicar")
    ResponseEntity publicar(@RequestBody Publicacion publicacion){
        return null;
    }

    @GetMapping("/{userID}/listado")
    ResponseEntity listado(@PathVariable("userID") Integer userId){
        return null;
    }

    @GetMapping("/promocion")
    ResponseEntity promocion(){
        return null;
    }

    @GetMapping("/promoción/{userID}/listado")
    ResponseEntity promocion(@PathVariable("userId")Integer userId){
        return null;
    }
}
