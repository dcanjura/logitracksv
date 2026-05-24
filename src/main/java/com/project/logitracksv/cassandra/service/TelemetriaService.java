package com.project.logitracksv.cassandra.service;

import com.project.logitracksv.cassandra.dto.TelemetriaRequestDTO;
import com.project.logitracksv.cassandra.dto.TelemetriaResponseDTO;
import com.project.logitracksv.cassandra.entity.TelemetriaEntity;
import com.project.logitracksv.cassandra.entity.TelemetriaKey;
import com.project.logitracksv.cassandra.repository.TelemetriaRepository;
import com.project.logitracksv.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TelemetriaService {

    private final TelemetriaRepository telemetriaRepository;

    public TelemetriaResponseDTO crear(TelemetriaRequestDTO dto) {
        TelemetriaEntity entity = TelemetriaEntity.builder()
                .key(new TelemetriaKey(dto.vehiculoId(), dto.fecha()))
                .latitud(dto.latitud())
                .longitud(dto.longitud())
                .velocidad(dto.velocidad())
                .combustible(dto.combustible())
                .temperaturaMotor(dto.temperaturaMotor())
                .build();

        return toDTO(telemetriaRepository.save(entity));
    }

    public List<TelemetriaResponseDTO> obtenerPorVehiculo(String vehiculoId) {
        return telemetriaRepository.findByKeyVehiculoId(vehiculoId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public List<TelemetriaResponseDTO> obtenerPorVehiculoYRango(
            String vehiculoId,
            Instant desde,
            Instant hasta
    ) {
        if (desde.isAfter(hasta)) {
            throw new BadRequestException("La fecha desde no puede ser posterior a la fecha hasta");
        }

        return telemetriaRepository.findByVehiculoIdAndFechaBetween(vehiculoId, desde, hasta)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private TelemetriaResponseDTO toDTO(TelemetriaEntity entity) {
        return new TelemetriaResponseDTO(
                entity.getKey().getVehiculoId(),
                entity.getKey().getFecha(),
                entity.getLatitud(),
                entity.getLongitud(),
                entity.getVelocidad(),
                entity.getCombustible(),
                entity.getTemperaturaMotor()
        );
    }
}
