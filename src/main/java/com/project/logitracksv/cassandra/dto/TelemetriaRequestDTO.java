package com.project.logitracksv.cassandra.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record TelemetriaRequestDTO(
        @NotBlank String vehiculoId,
        @NotNull Instant fecha,
        @NotNull Double latitud,
        @NotNull Double longitud,
        @NotNull Double velocidad,
        Double combustible,
        Double temperaturaMotor
) {
}
