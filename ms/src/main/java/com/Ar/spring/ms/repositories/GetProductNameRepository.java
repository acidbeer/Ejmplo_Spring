package com.Ar.spring.ms.repositories;

import com.Ar.spring.ms.models.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetProductNameRepository extends JpaRepository<ProductoEntity, Long> {

    List<ProductoEntity>findByNombreLike(String nombre);
}
