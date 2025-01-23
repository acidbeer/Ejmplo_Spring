package com.Ar.spring.ms.service;

import com.Ar.spring.ms.models.entity.ComprasEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PostCompraService {

    ComprasEntity guardarCompra(ComprasEntity compras);
}
