package com.project.logitracksv.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RutaRequestDTO(
        @NotNull @Valid ClienteRefDTO cliente,
        @NotNull @Valid VehiculoRefDTO vehiculo,
        @NotNull @Valid ConductorAsignadoDTO conductor,
        @NotBlank String origen,
        @NotBlank String destino,
        @NotNull LocalDateTime fechaSalida,
        @NotNull LocalDateTime fechaLlegadaEstimada,
        @NotBlank String estado
) {}
