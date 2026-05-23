package com.project.logitracksv.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rutas")
public class RutaEntity {

    @Id
    private String id;

    @NotNull
    @Valid
    private ClienteRef cliente;

    @NotNull
    @Valid
    private VehiculoRef vehiculo;

    @NotNull
    @Valid
    private ConductorAsignado conductor;

    @NotBlank
    private String origen;

    @NotBlank
    private String destino;

    @NotNull
    private LocalDateTime fechaSalida;

    @NotNull
    private LocalDateTime fechaLlegadaEstimada;

    @NotBlank
    private String estado; // EN_CURSO, FINALIZADA, CANCELADA
}