package com.project.logitracksv.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConductorAsignado {

    private String conductorId; // referencia

    // Datos desnormalizados
    private String nombre;
    private String licencia;
}