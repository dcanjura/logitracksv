package com.project.logitracksv.mapper;

import com.project.logitracksv.dto.AlertaRequestDTO;
import com.project.logitracksv.dto.AlertaResponseDTO;
import com.project.logitracksv.entity.AlertaEntity;

public class AlertaMapper {

    // Entity → ResponseDTO
    public static AlertaResponseDTO toDTO(AlertaEntity entity) {
        if (entity == null) return null;

        return new AlertaResponseDTO(
                entity.getId(),
                entity.getVehiculoId(),
                entity.getTipoAlerta(),
                entity.getValor(),
                entity.getLimite(),
                entity.getFecha(),
                entity.getEstado()
        );
    }

    // RequestDTO → Entity
    public static AlertaEntity toEntity(AlertaRequestDTO dto) {
        if (dto == null) return null;

        return AlertaEntity.builder()
                .vehiculoId(dto.vehiculoId())
                .tipoAlerta(dto.tipoAlerta())
                .valor(dto.valor())
                .limite(dto.limite())
                .fecha(dto.fecha())
                .estado(dto.estado())
                .build();
    }
}