package com.Ar.spring.ms.repositories;

import com.Ar.spring.ms.models.entity.ComprasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraResponseRepository extends JpaRepository<ComprasEntity, Long> {

}
