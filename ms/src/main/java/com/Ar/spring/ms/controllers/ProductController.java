package com.Ar.spring.ms.controllers;


import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductoEntity saveProduct(@RequestBody ProductoEntity producto){

        return this.productService.crearProducto(producto).getBody();
    }

    @GetMapping
    public ResponseEntity<List<ProductoEntity>> getProducts(){

        return ResponseEntity.ok(productService.consutarProductos()).getBody();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductoEntity>> getProducto(@PathVariable Long id){

        return ResponseEntity.ok(productService.consultarProductoById(id)).getBody();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoEntity> putProducto(@RequestBody ProductoEntity producto,
                                                      @PathVariable Long id){

        return ResponseEntity.ok(productService.modificarProductoById(producto,id)).getBody();

    }

    @DeleteMapping("/{id}")
    public String deletProduc(@PathVariable Long id){

        boolean ok=productService.eliminarProductoById(id);
        if(ok){

            return "Product with id "+ id + " deleted!";
        }else {

            return "Error, we have a problem and can´t delete Product with id : "+id;
        }
    }

}
