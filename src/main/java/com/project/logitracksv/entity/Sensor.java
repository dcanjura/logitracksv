package com.project.logitracksv.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    private String tipo;
    private Boolean activo;

    // Opcional dependiendo del sensor
    private Double rangoMax;
}