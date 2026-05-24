package com.project.logitracksv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AlertaRequestDTO(
        @NotBlank String vehiculoId,
        @NotBlank String tipoAlerta,
        @NotNull Double valor,
        @NotNull Double limite,
        @NotNull LocalDateTime fecha,
        @NotBlank String estado
) {}
