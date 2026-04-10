package com.project.logitracksv.dto;

import java.time.LocalDateTime;

public record AlertaRequestDTO(
        String vehiculoId,
        String tipoAlerta,
        Double valor,
        Double limite,
        LocalDateTime fecha,
        String estado
) {}