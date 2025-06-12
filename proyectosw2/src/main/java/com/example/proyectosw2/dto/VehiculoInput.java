package com.example.proyectosw2.dto;
import lombok.Data;

@Data
public class VehiculoInput {
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private String placa;    
    private String tipo; // Por ejemplo: "Sedán", "SUV", "Camioneta", etc.
    private String estado; // Por ejemplo: "Disponible", "En uso", "Mantenimiento"
    private String usuario_id; // ID del propietario del vehículo
}
