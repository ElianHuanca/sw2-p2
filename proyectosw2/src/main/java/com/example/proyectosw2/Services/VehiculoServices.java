package com.example.proyectosw2.Services;

import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
//import com.example.proyectosw2.dto.VehiculoConUsuarioDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.proyectosw2.Entity.UsuarioEntity;
import com.example.proyectosw2.Entity.VehiculoEntity;
import com.example.proyectosw2.Repository.UsuarioRepository;
import com.example.proyectosw2.Repository.VehiculoRepository;
import com.example.proyectosw2.dto.VehiculoInput;

@Service
public class VehiculoServices {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<VehiculoEntity> obtenerVehiculos() {
        // return vehiculoRepository.findAll();
        List<VehiculoEntity> vehiculos = vehiculoRepository.findAll();

        return vehiculos.stream()
                .map((VehiculoEntity vehiculo) -> {
                    Optional<UsuarioEntity> usuario = usuarioRepository
                            .findById(new ObjectId(vehiculo.getUsuario_id()));
                    return VehiculoEntity.builder()
                            .id(vehiculo.getId())
                            .marca(vehiculo.getMarca())
                            .modelo(vehiculo.getModelo())
                            .anio(vehiculo.getAnio())
                            .color(vehiculo.getColor())
                            .placa(vehiculo.getPlaca())
                            .tipo(vehiculo.getTipo())
                            .estado(vehiculo.getEstado())
                            .usuario_id(vehiculo.getUsuario_id())
                            .usuario_nombre(usuario.map(UsuarioEntity::getNombre).orElse("Desconocido"))
                            .build();
                })
                .collect(Collectors.toList());
    }

    public VehiculoEntity crearVehiculo(VehiculoInput input) {
        VehiculoEntity nuevoVehiculo = VehiculoEntity.builder()
                .marca(input.getMarca())
                .modelo(input.getModelo())
                .anio(input.getAnio())
                .color(input.getColor())
                .placa(input.getPlaca())
                .tipo(input.getTipo())
                .estado(input.getEstado())
                .usuario_id(input.getUsuario_id())
                .build();

        return vehiculoRepository.save(nuevoVehiculo);
    }
}
