package com.example.proyectosw2.Controller;

import com.example.proyectosw2.Entity.UsuarioEntity;
import com.example.proyectosw2.Services.UsuarioServices;
import com.example.proyectosw2.dto.UsuarioInput;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @QueryMapping
    public UsuarioEntity login(@Argument("input") UsuarioInput input) {
        UsuarioEntity usuario_response = usuarioServices.login(input.getEmail(),
                input.getPassword());
        if (usuario_response == null) {
            throw new RuntimeException("Credenciales inválidas");
        }
        return usuario_response;
    }

    @QueryMapping
    public List<UsuarioEntity> obtenerUsuarios() {
        return usuarioServices.obtenerUsuarios();
    }

    @QueryMapping
    public UsuarioEntity obtenerUsuario(@Argument String id) {
        UsuarioEntity usuario = usuarioServices.obtenerUsuario(id);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        return usuario;
    }

    @MutationMapping
    public UsuarioEntity crearUsuario(@Argument("input") UsuarioInput input) {
        UsuarioEntity existingUsuario = usuarioServices.findByEmail(input.getEmail());
        if (existingUsuario != null) {
            throw new IllegalArgumentException("El usuario con el email " + input.getEmail() + " ya existe.");
        }

        String passwordEncriptada = passwordEncoder.encode(input.getPassword());

        UsuarioEntity nuevoUsuario = UsuarioEntity.builder()
                .nombre(input.getNombre())
                .email(input.getEmail())
                .password(passwordEncriptada)
                .rol_id(input.getRol_id())
                .build();
        return usuarioServices.crearUsuario(nuevoUsuario);
    }
}
