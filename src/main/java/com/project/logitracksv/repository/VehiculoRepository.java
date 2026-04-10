package com.project.logitracksv.repository;

import com.project.logitracksv.entity.VehiculoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiculoRepository extends MongoRepository<VehiculoEntity, String> {

    Page<VehiculoEntity> findByEstado(String estado, Pageable pageable);
}