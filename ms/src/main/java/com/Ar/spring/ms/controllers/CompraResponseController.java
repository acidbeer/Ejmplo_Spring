package com.Ar.spring.ms.controllers;

import com.Ar.spring.ms.models.dto.CompraResponseDTO;
import com.Ar.spring.ms.models.entity.ComprasEntity;
import com.Ar.spring.ms.service.CompraResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compraRes")
public class CompraResponseController {

    @Autowired
    private CompraResponseService compraResponseService;

    @PostMapping
    public ResponseEntity<CompraResponseDTO>realizarCompra(@RequestBody ComprasEntity compras){

        CompraResponseDTO response = compraResponseService.guardarCompra(compras).getBody();

        return ResponseEntity.ok(response);
    }


}
