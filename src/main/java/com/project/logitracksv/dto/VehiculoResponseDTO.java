package com.project.logitracksv.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record VehiculoResponseDTO(
        String id,
        String placa,
        String modelo,
        Integer anio,
        String estado,
        ConductorAsignadoDTO conductorAsignado,
        List<SensorDTO> sensoresInstalados,
        LocalDate ultimaMantenimiento,
        LocalDateTime fechaCreacion
) {}