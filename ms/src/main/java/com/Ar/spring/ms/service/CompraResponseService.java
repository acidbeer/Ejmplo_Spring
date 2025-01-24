package com.Ar.spring.ms.service;

import com.Ar.spring.ms.models.dto.CompraResponseDTO;
import com.Ar.spring.ms.models.entity.ComprasEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CompraResponseService {

    ResponseEntity<CompraResponseDTO> guardarCompra(ComprasEntity compras);
}
