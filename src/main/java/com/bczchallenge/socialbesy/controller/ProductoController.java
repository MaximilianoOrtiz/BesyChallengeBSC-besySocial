
package com.bczchallenge.socialbesy.controller;

import com.bczchallenge.socialbesy.domain.dto.*;
import com.bczchallenge.socialbesy.domain.models.Publicacion;
import com.bczchallenge.socialbesy.service.interfaces.ProductoInterface;
import com.bczchallenge.socialbesy.service.interfaces.PublicacionInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/productos")
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
    @PostMapping("/promocion")
    ResponseEntity publicarPromocion(@RequestBody PublicacionRequestDTO publicacion){
        try{
            Map<String, Object>mensaje= new HashMap<String, Object>();
            DTOPromocioProducto data = this.publicacionInterface.publicarPromocion(publicacion);
            //TODO
            // mensaje.put("publicacion_id", data.getId());
            // TODO
            //  mensaje.put("Data", data.getPrecioDescuento);
            mensaje.put("Success", Boolean.TRUE);
            mensaje.put("Data", data);
            return ResponseEntity.ok(mensaje);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("/{userID}/listado")
    ResponseEntity listado(@PathVariable("userID") Integer userId){
        log.info("INICIO --> listado("+userId+")");
        Map<String, Object>mensaje= new HashMap<String, Object>();
        try{

            DTOPublicacionResponse data= this.publicacionInterface.listado(userId);
            mensaje.put("userId", userId);
            mensaje.put("Data", data);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        log.info("INICIO --> listado() response: "+ mensaje.get("Data"));
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/promocion/{userID}/listado")
    ResponseEntity promocion(@PathVariable("userID") Integer userID){
        log.info("INICIO --> promocion("+userID+")");
        Map<String, Object>mensaje= new HashMap<String, Object>();
        try{

            DTOPromocionResponse data= this.publicacionInterface.promocion(userID);
            mensaje.put("userId", userID);
            mensaje.put("Data", data);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        log.info("INICIO --> promocion() response: "+ mensaje.get("Data"));
        return ResponseEntity.ok(mensaje);    }


}

