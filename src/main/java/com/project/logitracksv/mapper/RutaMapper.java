package com.project.logitracksv.mapper;

import com.project.logitracksv.dto.*;
import com.project.logitracksv.entity.*;

public class RutaMapper {

    // Entity → ResponseDTO
    public static RutaResponseDTO toDTO(RutaEntity entity) {
        if (entity == null) return null;

        return new RutaResponseDTO(
                entity.getId(),
                toClienteDTO(entity.getCliente()),
                toVehiculoDTO(entity.getVehiculo()),
                toConductorDTO(entity.getConductor()),
                entity.getOrigen(),
                entity.getDestino(),
                entity.getFechaSalida(),
                entity.getFechaLlegadaEstimada(),
                entity.getEstado()
        );
    }

    // RequestDTO → Entity
    public static RutaEntity toEntity(RutaRequestDTO dto) {
        if (dto == null) return null;

        return RutaEntity.builder()
                .cliente(toClienteEntity(dto.cliente()))
                .vehiculo(toVehiculoEntity(dto.vehiculo()))
                .conductor(toConductorEntity(dto.conductor()))
                .origen(dto.origen())
                .destino(dto.destino())
                .fechaSalida(dto.fechaSalida())
                .fechaLlegadaEstimada(dto.fechaLlegadaEstimada())
                .estado(dto.estado())
                .build();
    }

    // ---------- CLIENTE ----------

    private static ClienteRefDTO toClienteDTO(ClienteRef entity) {
        if (entity == null) return null;

        return new ClienteRefDTO(
                entity.getClienteId(),
                entity.getNombre()
        );
    }

    private static ClienteRef toClienteEntity(ClienteRefDTO dto) {
        if (dto == null) return null;

        return ClienteRef.builder()
                .clienteId(dto.clienteId())
                .nombre(dto.nombre())
                .build();
    }

    // ---------- VEHICULO ----------

    private static VehiculoRefDTO toVehiculoDTO(VehiculoRef entity) {
        if (entity == null) return null;

        return new VehiculoRefDTO(
                entity.getVehiculoId(),
                entity.getPlaca(),
                entity.getModelo()
        );
    }

    private static VehiculoRef toVehiculoEntity(VehiculoRefDTO dto) {
        if (dto == null) return null;

        return VehiculoRef.builder()
                .vehiculoId(dto.vehiculoId())
                .placa(dto.placa())
                .modelo(dto.modelo())
                .build();
    }

    // ---------- CONDUCTOR ----------

    private static ConductorAsignadoDTO toConductorDTO(ConductorAsignado entity) {
        if (entity == null) return null;

        return new ConductorAsignadoDTO(
                entity.getConductorId(),
                entity.getNombre(),
                null // licencia no existe en Ruta
        );
    }

    private static ConductorAsignado toConductorEntity(ConductorAsignadoDTO dto) {
        if (dto == null) return null;

        return ConductorAsignado.builder()
                .conductorId(dto.conductorId())
                .nombre(dto.nombre())
                .build();
    }
}