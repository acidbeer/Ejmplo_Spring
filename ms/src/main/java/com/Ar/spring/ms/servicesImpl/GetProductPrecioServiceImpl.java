package com.Ar.spring.ms.servicesImpl;

import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.repositories.GetProductPrecioRepository;
import com.Ar.spring.ms.service.GetProductPrecioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductPrecioServiceImpl implements GetProductPrecioService {

    private final Logger logger= LoggerFactory.getLogger(GetProductPrecioServiceImpl.class);


    @Autowired
    private GetProductPrecioRepository getProductPrecioRepository;


    @Override
    public List<ProductoEntity> consultaByPrecio(Double precio) {
        logger.info("Inicia el servico de consulta por precio menor");
        return getProductPrecioRepository.findByPrecioLessThan(precio);
    }
}
