package com.Ar.spring.ms.controllers;

import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.service.GetProductPsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/params")
public class GetProductPsController {

    @Autowired
    private GetProductPsService getProductPsService;

    @GetMapping("/find-price-stock")
    public ResponseEntity<List<ProductoEntity>> getProductByPriceAndStock(@RequestParam("precio") double precio,
                                                                          @RequestParam("stock") int stock){

        List<ProductoEntity> productos=getProductPsService.consultaByPriceAndStock(precio,stock);

        if (productos.isEmpty()){

            return ResponseEntity.notFound().build();
        }else {

            return ResponseEntity.ok(productos);
        }
    }
}
