package com.project.logitracksv.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConductorAsignado {

    @NotBlank
    private String conductorId; // referencia

    // Datos desnormalizados
    @NotBlank
    private String nombre;

    @NotBlank
    private String licencia;
}