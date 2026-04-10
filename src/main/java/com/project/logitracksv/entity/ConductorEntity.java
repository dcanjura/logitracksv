package com.project.logitracksv.entity;

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

    private String nombre;
    private String telefono;
    private String licencia;
    private String tipoLicencia;
    private String estado;
    private LocalDate fechaContratacion;
}