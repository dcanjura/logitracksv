package com.project.logitracksv.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "conductores")
public class ConductorEntity {

    @Id
    private String id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String telefono;

    @NotBlank
    private String licencia;

    @NotBlank
    private String tipoLicencia;

    @NotBlank
    private String estado;

    @NotNull
    private LocalDate fechaContratacion;
}