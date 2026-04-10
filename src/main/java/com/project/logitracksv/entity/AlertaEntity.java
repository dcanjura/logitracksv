package com.project.logitracksv.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "alertas")
public class AlertaEntity {

    @Id
    private String id;

    private String vehiculoId;

    private String tipoAlerta; // TEMPERATURA_ALTA, MOTOR_FALLA, etc.
    private Double valor;
    private Double limite;

    private LocalDateTime fecha;

    private String estado; // ACTIVA, RESUELTA
}