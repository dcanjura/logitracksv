package com.project.logitracksv.entity;

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
@Document(collection = "alertas")
public class AlertaEntity {

    @Id
    private String id;

    @NotBlank
    private String vehiculoId;

    @NotBlank
    private String tipoAlerta; // TEMPERATURA_ALTA, MOTOR_FALLA, etc.

    @NotNull
    private Double valor;

    @NotNull
    private Double limite;

    @NotNull
    private LocalDateTime fecha;

    @NotBlank
    private String estado; // ACTIVA, RESUELTA
}