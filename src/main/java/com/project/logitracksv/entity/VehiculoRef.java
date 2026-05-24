package com.project.logitracksv.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoRef {

    @NotBlank
    private String vehiculoId;

    @NotBlank
    private String placa;

    @NotBlank
    private String modelo;
}