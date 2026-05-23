package com.project.logitracksv.dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDTO(
        @NotBlank String nombre,
        @NotBlank String direccion,
        @NotBlank String telefono,
        @NotBlank String email,
        @NotBlank String estado
) {}
