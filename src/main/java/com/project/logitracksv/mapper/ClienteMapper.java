package com.project.logitracksv.mapper;

import com.project.logitracksv.dto.ClienteRequestDTO;
import com.project.logitracksv.dto.ClienteResponseDTO;
import com.project.logitracksv.entity.ClienteEntity;

public class ClienteMapper {

    // Entity → ResponseDTO
    public static ClienteResponseDTO toDTO(ClienteEntity entity) {
        if (entity == null) return null;

        return new ClienteResponseDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getDireccion(),
                entity.getTelefono(),
                entity.getEmail(),
                entity.getEstado()
        );
    }

    // RequestDTO → Entity
    public static ClienteEntity toEntity(ClienteRequestDTO dto) {
        if (dto == null) return null;

        return ClienteEntity.builder()
                .nombre(dto.nombre())
                .direccion(dto.direccion())
                .telefono(dto.telefono())
                .email(dto.email())
                .estado(dto.estado())
                .build();
    }
}