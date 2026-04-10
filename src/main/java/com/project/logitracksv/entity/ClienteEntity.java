package com.project.logitracksv.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
public class ClienteEntity {

    @Id
    private String id;

    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String estado;
}