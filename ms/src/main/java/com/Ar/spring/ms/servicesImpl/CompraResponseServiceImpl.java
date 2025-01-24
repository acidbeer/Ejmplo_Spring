package com.Ar.spring.ms.servicesImpl;

import com.Ar.spring.ms.mapper.ComprasMapper;
import com.Ar.spring.ms.models.dto.CompraResponseDTO;
import com.Ar.spring.ms.models.entity.ComprasEntity;
import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.models.entity.UserEntity;
import com.Ar.spring.ms.repositories.CompraResponseRepository;
import com.Ar.spring.ms.repositories.IProductRepository;
import com.Ar.spring.ms.service.CompraResponseService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class CompraResponseServiceImpl implements CompraResponseService {

    private final Logger logger = LoggerFactory.getLogger(CompraResponseServiceImpl.class);

    @Autowired
    private final CompraResponseRepository compraResponseRepository;

    @Autowired
    private final IProductRepository iProductRepository;

    @Autowired
    private final ComprasMapper comprasMapper;

    @Override
    public ResponseEntity<CompraResponseDTO> guardarCompra(ComprasEntity compras) {
        logger.info("Inicia el metodo para guardar compra con response DTO");

        //validar si el producto existe
        ProductoEntity producto = iProductRepository.findById(compras.getProductoId().getId())
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));

        //validar si el stock es suficiente
        if(producto.getStock() < compras.getCantidad()){

            throw new RuntimeException("Stock insificiente para el producto: "+ producto.getNombre());

        }else {

            //Actualiza el stock
            producto.setStock(producto.getStock() - compras.getCantidad());
            iProductRepository.save(producto);

        }

        //guarda la compra
        ComprasEntity savedCompra= compraResponseRepository.save(compras);

        //mapear a comprasResponseDTO
        return ResponseEntity.ok(comprasMapper.toCompraResponseDTO(savedCompra,producto));

    }
}
