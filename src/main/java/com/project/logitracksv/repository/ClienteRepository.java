package com.project.logitracksv.repository;

import com.project.logitracksv.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {

    Page<ClienteEntity> findByEstado(String estado, Pageable pageable);

    Page<ClienteEntity> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
}