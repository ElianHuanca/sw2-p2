package com.example.proyectosw2.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.proyectosw2.Repository.UsuarioRepository;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/conexion")
    public ResponseEntity<?> testConexion() {
        try {
            long count = usuarioRepository.count();
            return ResponseEntity.ok("Conexión OK. Usuarios en BD: " + count);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error de conexión: " + e.getMessage());
        }
    }
}
