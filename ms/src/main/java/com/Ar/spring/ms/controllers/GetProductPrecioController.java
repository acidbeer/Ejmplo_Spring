package com.Ar.spring.ms.controllers;

import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.service.GetProductPrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/price")
public class GetProductPrecioController {

    @Autowired
    private GetProductPrecioService getProductPrecioService;



    @GetMapping("/find-price")
    public ResponseEntity<List<ProductoEntity>> getPrice(@RequestParam("precio") double precio){

        List<ProductoEntity> productos= getProductPrecioService.consultaByPrecio(precio);

        if (productos.isEmpty()) {

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);

    }

}
