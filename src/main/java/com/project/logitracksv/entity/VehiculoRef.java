package com.project.logitracksv.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoRef {

    private String vehiculoId;
    private String placa;
    private String modelo;
}