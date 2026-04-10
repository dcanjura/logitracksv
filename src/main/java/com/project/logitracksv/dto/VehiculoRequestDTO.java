package com.project.logitracksv.dto;

import java.time.LocalDate;
import java.util.List;

public record VehiculoRequestDTO(
        String placa,
        String modelo,
        Integer anio,
        String estado,
        ConductorAsignadoDTO conductorAsignado,
        List<SensorDTO> sensoresInstalados,
        LocalDate ultimaMantenimiento
) {}