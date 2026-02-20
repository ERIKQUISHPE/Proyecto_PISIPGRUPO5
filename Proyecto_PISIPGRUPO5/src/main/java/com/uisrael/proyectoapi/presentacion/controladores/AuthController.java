package com.uisrael.proyectoapi.presentacion.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.uisrael.proyectoapi.dominio.repositorios.IUsuarioRepositorio;
import com.uisrael.proyectoapi.presentacion.dto.request.LoginRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.LoginResponseDTO;

@RestController
@RequestMapping({"/auth", "/api/auth"})
public class AuthController {

    private final IUsuarioRepositorio usuarioRepo;
    private final BCryptPasswordEncoder encoder;

    public AuthController(IUsuarioRepositorio usuarioRepo, BCryptPasswordEncoder encoder) {
        this.usuarioRepo = usuarioRepo;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO req) {

        var uOpt = usuarioRepo.buscarPorUsuario(req.getUsuario());
        if (uOpt.isEmpty()) return ResponseEntity.status(401).body("Credenciales incorrectas");

        var u = uOpt.get();
        if (!u.isEstado()) return ResponseEntity.status(401).body("Usuario inactivo");

        if (u.getPasswordHash() == null || u.getPasswordHash().isBlank()) {
            return ResponseEntity.status(401).body("Usuario sin clave configurada");
        }

        if (!encoder.matches(req.getPassword(), u.getPasswordHash())) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        return ResponseEntity.ok(new LoginResponseDTO(true, u.getIdUsuario(), u.getUsuario(), u.getRol()));
    }
}
