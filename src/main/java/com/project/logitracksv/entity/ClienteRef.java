package com.project.logitracksv.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRef {

    private String clienteId;
    private String nombre;
}