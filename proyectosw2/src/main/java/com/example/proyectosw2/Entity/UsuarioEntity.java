package com.example.proyectosw2.Entity;

import lombok.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuarios")
public class UsuarioEntity {
    //private Integer id;
    @Id
    private ObjectId id;  // requiere: import org.bson.types.ObjectId;
    private String nombre;
    private String email;
    //private String password;
}