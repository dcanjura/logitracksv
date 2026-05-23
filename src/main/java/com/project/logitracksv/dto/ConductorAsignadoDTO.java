package com.project.logitracksv.dto;

import jakarta.validation.constraints.NotBlank;

public record ConductorAsignadoDTO(
        @NotBlank String conductorId,
        @NotBlank String nombre,
        @NotBlank String licencia
) {}
