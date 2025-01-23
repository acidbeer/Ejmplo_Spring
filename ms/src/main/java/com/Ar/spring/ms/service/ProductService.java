package com.Ar.spring.ms.service;


import com.Ar.spring.ms.models.entity.ProductoEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public ResponseEntity<ProductoEntity> crearProducto(ProductoEntity producto);

    public ResponseEntity<List<ProductoEntity>> consutarProductos();

    public ResponseEntity<Optional<ProductoEntity>> consultarProductoById(Long id);

    public ResponseEntity<ProductoEntity> modificarProductoById(ProductoEntity request, Long id);

    public boolean eliminarProductoById(Long id);




}
