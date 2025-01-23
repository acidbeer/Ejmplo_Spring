package com.Ar.spring.ms.servicesImpl;

import com.Ar.spring.ms.models.entity.ProductoEntity;
import com.Ar.spring.ms.repositories.GetProductPsRepository;
import com.Ar.spring.ms.service.GetProductPsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductPsServiceImpl implements GetProductPsService {

    private final Logger logger= LoggerFactory.getLogger(GetProductPsServiceImpl.class);

    @Autowired
    private GetProductPsRepository getProductPsRepository;


    @Override
    public List<ProductoEntity> consultaByPriceAndStock(double precio, int stock) {
        logger.info("Inicia el servicio para consulta por Precio mayor a y Stock menor a");

        // Precio mayor a y stock menor a
        return getProductPsRepository.findByPrecioGreaterThanAndStockLessThan(precio, stock);

    }
}
