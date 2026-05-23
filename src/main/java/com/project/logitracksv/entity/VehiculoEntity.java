package com.project.logitracksv.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String placa;

    @NotBlank
    private String modelo;

    @NotNull
    private Integer anio;

    @NotBlank
    private String estado;

    @Valid
    private ConductorAsignado conductorAsignado;

    @Valid
    private List<Sensor> sensoresInstalados;

    private LocalDate ultimaMantenimiento;
    private LocalDateTime fechaCreacion;
}