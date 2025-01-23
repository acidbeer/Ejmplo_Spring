package com.Ar.spring.ms.controllers;

import com.Ar.spring.ms.models.entity.ComprasEntity;
import com.Ar.spring.ms.service.PostCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class PostCompraController {

    @Autowired
    private final PostCompraService postCompraService;

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE })
    public ResponseEntity<ComprasEntity> saveCompras(@RequestBody ComprasEntity compras){

        return ResponseEntity.ok(postCompraService.guardarCompra(compras));

    }


}
