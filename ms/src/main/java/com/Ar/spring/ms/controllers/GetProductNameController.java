package com.Ar.spring.ms.controllers;

import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.service.GetProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/name")
public class GetProductNameController {

    @Autowired
    private GetProductNameService getProductNameService;

    @GetMapping("/find-name")
    public ResponseEntity<List<ProductoEntity>> getProductByName(@RequestParam("nombre") String nombre){

        List<ProductoEntity> producto= getProductNameService.consultaByName(nombre);

        if (producto.isEmpty()){

            return ResponseEntity.notFound().build();

        }else {

            return ResponseEntity.ok(producto);
        }
    }


}
