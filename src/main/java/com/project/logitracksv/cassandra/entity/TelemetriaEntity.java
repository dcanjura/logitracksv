package com.project.logitracksv.cassandra.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("telemetria")
public class TelemetriaEntity {

    @PrimaryKey
    @Valid
    private TelemetriaKey key;

    @NotNull
    @Column("latitud")
    private Double latitud;

    @NotNull
    @Column("longitud")
    private Double longitud;

    @NotNull
    @Column("velocidad")
    private Double velocidad;

    @Column("combustible")
    private Double combustible;

    @Column("temperatura_motor")
    private Double temperaturaMotor;
}
