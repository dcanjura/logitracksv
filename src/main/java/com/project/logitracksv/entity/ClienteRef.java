package com.project.logitracksv.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRef {

    @NotBlank
    private String clienteId;

    @NotBlank
    private String nombre;
}