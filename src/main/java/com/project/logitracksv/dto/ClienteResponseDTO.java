package com.project.logitracksv.dto;

public record ClienteResponseDTO(
        String id,
        String nombre,
        String direccion,
        String telefono,
        String email,
        String estado
) {}