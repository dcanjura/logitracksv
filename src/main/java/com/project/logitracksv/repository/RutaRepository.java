package com.project.logitracksv.repository;

import com.project.logitracksv.entity.RutaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RutaRepository extends MongoRepository<RutaEntity, String> {

    // FILTRO POR ESTADO
    Page<RutaEntity> findByEstado(String estado, Pageable pageable);

    // FILTRO POR CLIENTE
    Page<RutaEntity> findByCliente_ClienteId(String clienteId, Pageable pageable);

    // FILTRO POR VEHICULO
    Page<RutaEntity> findByVehiculo_VehiculoId(String vehiculoId, Pageable pageable);

    // FILTRO POR CONDUCTOR
    Page<RutaEntity> findByConductor_ConductorId(String conductorId, Pageable pageable);
}