package com.project.logitracksv.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "vehiculos")
public class VehiculoEntity {

    @Id
    private String id;

    private String placa;
    private String modelo;
    private Integer anio;
    private String estado;

    private ConductorAsignado conductorAsignado;

    private List<Sensor> sensoresInstalados;

    private LocalDate ultimaMantenimiento;
    private LocalDateTime fechaCreacion;
}