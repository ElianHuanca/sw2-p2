package com.example.proyectosw2.Controller;

import com.example.proyectosw2.Entity.VehiculoEntity;
import com.example.proyectosw2.Services.VehiculoServices;
import com.example.proyectosw2.dto.VehiculoInput;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class VehiculoController {
    @Autowired
    private VehiculoServices vehiculoService;

    @QueryMapping
    public List<VehiculoEntity> obtenerVehiculos() {
        return vehiculoService.obtenerVehiculos();
    }

    @MutationMapping
    public VehiculoEntity crearVehiculo(@Argument("input") VehiculoInput input) {
        return vehiculoService.crearVehiculo(input);
    }
}