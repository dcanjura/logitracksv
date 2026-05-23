package com.project.logitracksv.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @NotBlank
    private String tipo;

    @NotNull
    private Boolean activo;

    // Opcional dependiendo del sensor
    private Double rangoMax;
}