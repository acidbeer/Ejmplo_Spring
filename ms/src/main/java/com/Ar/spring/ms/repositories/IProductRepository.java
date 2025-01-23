package com.Ar.spring.ms.repositories;

import com.Ar.spring.ms.models.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductoEntity, Long> {

}
