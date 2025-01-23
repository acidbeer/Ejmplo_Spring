package com.Ar.spring.ms.servicesImpl;

import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.repositories.GetProductNameRepository;
import com.Ar.spring.ms.service.GetProductNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductNameServiceImpl implements GetProductNameService {

    private final Logger logger= LoggerFactory.getLogger(GetProductPrecioServiceImpl.class);

    @Autowired
    private GetProductNameRepository getProductNameRepository;


    @Override
    public List<ProductoEntity> consultaByName(String nombre) {
        logger.info("Inicia el servicio de consulta por nombre de producto");

        return getProductNameRepository.findByNombreLike(nombre);

    }
}
