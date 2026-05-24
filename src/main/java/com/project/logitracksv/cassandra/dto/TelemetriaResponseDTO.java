package com.project.logitracksv.cassandra.dto;

import java.time.Instant;

public record TelemetriaResponseDTO(
        String vehiculoId,
        Instant fecha,
        Double latitud,
        Double longitud,
        Double velocidad,
        Double combustible,
        Double temperaturaMotor
) {
}
