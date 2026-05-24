package com.project.logitracksv.dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteRefDTO(
        @NotBlank String clienteId,
        @NotBlank String nombre
) {}
