package com.example.proyectosw2.Services;

import com.example.proyectosw2.Entity.UsuarioEntity;
import com.example.proyectosw2.Repository.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    public UsuarioEntity login(String email, String password) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(email).orElse(null);
        if (usuario == null)
            return null;
        if (passwordEncoder.matches(password, usuario.getPassword())) {
            String token = tokenService.generateToken(email);
            usuario.setPassword(null);
            usuario.setToken(token);
            return usuario;
        } else {
            return null;
        }
    }

    public List<UsuarioEntity> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity obtenerUsuario(String id) {
        return usuarioRepository.findById(new org.bson.types.ObjectId(id)).orElse(null);
    }

    public UsuarioEntity findById(String id) {
        return usuarioRepository.findById(new org.bson.types.ObjectId(id)).orElse(null);
    }

    public UsuarioEntity findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    public UsuarioEntity crearUsuario(UsuarioEntity usuario) {
        try {
            UsuarioEntity new_usuario = usuarioRepository.save(usuario);
            new_usuario.setPassword(null); 
            return new_usuario;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
