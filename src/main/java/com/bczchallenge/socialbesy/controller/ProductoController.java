
package com.bczchallenge.socialbesy.controller;

import com.bczchallenge.socialbesy.domain.dto.PublicacionProductoDTO;
import com.bczchallenge.socialbesy.domain.dto.PublicacionRequestDTO;
import com.bczchallenge.socialbesy.domain.models.Publicacion;
import com.bczchallenge.socialbesy.service.interfaces.ProductoInterface;
import com.bczchallenge.socialbesy.service.interfaces.PublicacionInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
   // private final ProductoInterface productoInterface;
    private final PublicacionInterface publicacionInterface;

    @PostMapping("/publicar")
    ResponseEntity publicar(@RequestBody PublicacionRequestDTO publicacion){
        try{
            Map<String, Object>mensaje= new HashMap<String, Object>();
            PublicacionProductoDTO data= this.publicacionInterface.publicar(publicacion);
            mensaje.put("Success", true);
            mensaje.put("Data", data);

            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
/*
    @GetMapping("/{userID}/listado")
    ResponseEntity listado(@PathVariable("userID") Integer userId){
        try{
            Map<String, Object>mensaje= new HashMap<String, Object>();

            Collection<Publicacion> data= this.publicacionInterface.listado(userId);
            mensaje.put("userId", userId);
            mensaje.put("Data", data);

            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/promocion")
    ResponseEntity promocion(@RequestBody Publicacion publicacion){
        try{
            Map<String, Object>mensaje= new HashMap<String, Object>();
            Publicacion data= this.publicacionInterface.promocion(publicacion);
            //TODO
            // mensaje.put("publicacion_id", data.getId());
            // TODO
            //  mensaje.put("Data", data.getPrecioDescuento);
            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/promoción/{userID}/listado")
    ResponseEntity promocion(@PathVariable("userId")Integer userId){
        return null;
    }*/


}

