package com.project.logitracksv.dto;

public record SensorDTO(
        String tipo,
        Boolean activo,
        Double rangoMax
) {}