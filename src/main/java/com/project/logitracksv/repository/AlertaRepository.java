package com.project.logitracksv.repository;

import com.project.logitracksv.entity.AlertaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertaRepository extends MongoRepository<AlertaEntity, String> {

    Page<AlertaEntity> findByVehiculoId(String vehiculoId, Pageable pageable);

    Page<AlertaEntity> findByEstado(String estado, Pageable pageable);

    Page<AlertaEntity> findByTipoAlerta(String tipoAlerta, Pageable pageable);
}