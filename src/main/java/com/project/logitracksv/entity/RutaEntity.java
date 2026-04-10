package com.project.logitracksv.entity;

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

    private ClienteRef cliente;
    private VehiculoRef vehiculo;
    private ConductorAsignado conductor;

    private String origen;
    private String destino;

    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegadaEstimada;

    private String estado; // EN_CURSO, FINALIZADA, CANCELADA
}