package com.Ar.spring.ms.repositories;

import com.Ar.spring.ms.models.entity.ComprasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCompraRepository extends JpaRepository<ComprasEntity, Long> {


}
