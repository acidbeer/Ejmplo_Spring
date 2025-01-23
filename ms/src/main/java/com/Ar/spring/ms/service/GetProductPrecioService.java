package com.Ar.spring.ms.service;


import com.Ar.spring.ms.models.entity.ProductoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetProductPrecioService {

    public List<ProductoEntity> consultaByPrecio(Double precio);

}
