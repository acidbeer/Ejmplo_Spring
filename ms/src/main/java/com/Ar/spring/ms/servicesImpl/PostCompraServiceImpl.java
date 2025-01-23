package com.Ar.spring.ms.servicesImpl;

import com.Ar.spring.ms.models.entity.ComprasEntity;
import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.repositories.IProductRepository;
import com.Ar.spring.ms.repositories.PostCompraRepository;
import com.Ar.spring.ms.service.PostCompraService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Transactional // Asegura que ambas operaciones (guardar compra y actualizar stock) sean atómicas
public class PostCompraServiceImpl implements PostCompraService {

    private final Logger logger= LoggerFactory.getLogger(PostCompraServiceImpl.class);

    @Autowired
    private PostCompraRepository postCompraRepository;

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public ComprasEntity guardarCompra(ComprasEntity compras) {

        logger.info("Inicia el servicio para guardar compra Validando si existe el producto !");
       //primero verificamos si el producto existe
        ProductoEntity producto = (iProductRepository.findById(compras.getProductoId().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado")));

        logger.info("Validando si el stock es suficiente !");
        //Verificar que hay stock suficiente
        if (producto.getStock() < compras.getCantidad()){

            throw new RuntimeException("Stock insuficiente para el producto: "+producto.getNombre());
        }else {
            logger.info("Actualiza el stock !");
            // Actualizar el stock del producto
            producto.setStock(producto.getStock() - compras.getCantidad());
            iProductRepository.save(producto);
        }
        logger.info("finaliza y servicio guardando la compra !");
        // Guardar la compra
        return postCompraRepository.save(compras);
    }

}
