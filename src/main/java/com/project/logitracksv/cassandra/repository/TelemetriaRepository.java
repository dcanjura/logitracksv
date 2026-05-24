package com.project.logitracksv.cassandra.repository;

import com.project.logitracksv.cassandra.entity.TelemetriaEntity;
import com.project.logitracksv.cassandra.entity.TelemetriaKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.time.Instant;
import java.util.List;

public interface TelemetriaRepository extends CassandraRepository<TelemetriaEntity, TelemetriaKey> {

    List<TelemetriaEntity> findByKeyVehiculoId(String vehiculoId);

    @Query("SELECT * FROM telemetria WHERE vehiculo_id = ?0 AND fecha >= ?1 AND fecha <= ?2")
    List<TelemetriaEntity> findByVehiculoIdAndFechaBetween(String vehiculoId, Instant desde, Instant hasta);
}
