package com.Ar.spring.ms.servicesImpl;

import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.repositories.IProductRepository;
import com.Ar.spring.ms.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private IProductRepository iProductRepository;

    public ResponseEntity<ProductoEntity> crearProducto(ProductoEntity producto){
        logger.info("Inicia el servicio para la creacion de Producto");

        return ResponseEntity.ok(iProductRepository.save(producto));
    }

    public ResponseEntity<List<ProductoEntity>> consutarProductos(){
        logger.info("Inicia el servicio para la consulta de produtos");

        return ResponseEntity.ok(iProductRepository.findAll());
    }

    public ResponseEntity<Optional<ProductoEntity>> consultarProductoById(Long id){
        logger.info("Inicia el servicio de consulta de productos por Id");

        return ResponseEntity.ok(iProductRepository.findById(id));
    }

    public ResponseEntity<ProductoEntity> modificarProductoById(ProductoEntity request, Long id){
        logger.info("Inicia el servicio para modificar producto por Id");

        //primero obtenemos el id
        ProductoEntity productoencontrado=iProductRepository.findById(id).get();

        //seteamos los cambios realizados y obtenmos el valor
        productoencontrado.setNombre(request.getNombre());
        productoencontrado.setPrecio(request.getPrecio());
        productoencontrado.setStock(request.getStock());

        return ResponseEntity.ok(iProductRepository.save(productoencontrado));
    }

    public boolean eliminarProductoById(Long id){
        logger.info("Inicia el servico para eliminar producto por Id");

        try {

            iProductRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
