package com.project.logitracksv.mapper;

import com.project.logitracksv.dto.*;
import com.project.logitracksv.entity.*;

import java.time.LocalDateTime;
import java.util.List;

public class VehiculoMapper {

    // Entity → ResponseDTO
    public static VehiculoResponseDTO toDTO(VehiculoEntity entity) {
        return new VehiculoResponseDTO(
                entity.getId(),
                entity.getPlaca(),
                entity.getModelo(),
                entity.getAnio(),
                entity.getEstado(),
                toConductorDTO(entity.getConductorAsignado()),
                toSensorDTOList(entity.getSensoresInstalados()),
                entity.getUltimaMantenimiento(),
                entity.getFechaCreacion()
        );
    }

    // RequestDTO → Entity
    public static VehiculoEntity toEntity(VehiculoRequestDTO dto) {
        return VehiculoEntity.builder()
                .placa(dto.placa())
                .modelo(dto.modelo())
                .anio(dto.anio())
                .estado(dto.estado())
                .conductorAsignado(toConductorEntity(dto.conductorAsignado()))
                .sensoresInstalados(toSensorEntityList(dto.sensoresInstalados()))
                .ultimaMantenimiento(dto.ultimaMantenimiento())
                .fechaCreacion(LocalDateTime.now())
                .build();
    }

    // ---------- MAPPERS INTERNOS ----------

    private static ConductorAsignadoDTO toConductorDTO(ConductorAsignado c) {
        if (c == null) return null;
        return new ConductorAsignadoDTO(
                c.getConductorId(),
                c.getNombre(),
                c.getLicencia()
        );
    }

    private static ConductorAsignado toConductorEntity(ConductorAsignadoDTO dto) {
        if (dto == null) return null;
        return ConductorAsignado.builder()
                .conductorId(dto.conductorId())
                .nombre(dto.nombre())
                .licencia(dto.licencia())
                .build();
    }

    private static List<SensorDTO> toSensorDTOList(List<Sensor> sensores) {
        if (sensores == null) return List.of();
        return sensores.stream()
                .map(s -> new SensorDTO(s.getTipo(), s.getActivo(), s.getRangoMax()))
                .toList();
    }

    private static List<Sensor> toSensorEntityList(List<SensorDTO> sensores) {
        if (sensores == null) return List.of();
        return sensores.stream()
                .map(s -> Sensor.builder()
                        .tipo(s.tipo())
                        .activo(s.activo())
                        .rangoMax(s.rangoMax())
                        .build())
                .toList();
    }
}