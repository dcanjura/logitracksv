package com.project.logitracksv.dto;

import jakarta.validation.constraints.NotBlank;

public record VehiculoRefDTO(
        @NotBlank String vehiculoId,
        @NotBlank String placa,
        @NotBlank String modelo
) {}
