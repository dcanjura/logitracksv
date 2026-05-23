package com.project.logitracksv.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record VehiculoRequestDTO(
        @NotBlank String placa,
        @NotBlank String modelo,
        @NotNull Integer anio,
        @NotBlank String estado,
        @Valid ConductorAsignadoDTO conductorAsignado,
        @Valid List<SensorDTO> sensoresInstalados,
        LocalDate ultimaMantenimiento
) {}
