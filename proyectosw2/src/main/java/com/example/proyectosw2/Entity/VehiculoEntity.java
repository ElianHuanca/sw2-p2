package com.example.proyectosw2.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "vehiculos")
public class VehiculoEntity {
    @Id
    private ObjectId id;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private String placa;
    private String tipo;
    private String estado;
    private String usuario_id;
    private String usuario_nombre;
}
