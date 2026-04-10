package com.project.logitracksv.dto;

import java.time.LocalDateTime;

public record RutaResponseDTO(
        String id,
        ClienteRefDTO cliente,
        VehiculoRefDTO vehiculo,
        ConductorAsignadoDTO conductor,
        String origen,
        String destino,
        LocalDateTime fechaSalida,
        LocalDateTime fechaLlegadaEstimada,
        String estado
) {}