package com.project.logitracksv.dto;

public record ClienteRequestDTO(
        String nombre,
        String direccion,
        String telefono,
        String email,
        String estado
) {}