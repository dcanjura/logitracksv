package com.project.logitracksv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SensorDTO(
        @NotBlank String tipo,
        @NotNull Boolean activo,
        Double rangoMax
) {}
