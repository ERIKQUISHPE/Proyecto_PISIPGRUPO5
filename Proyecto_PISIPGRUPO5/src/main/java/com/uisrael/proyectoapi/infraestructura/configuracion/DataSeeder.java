package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.UsuarioJpa;
import com.uisrael.proyectoapi.infraestructura.repositorios.IUsuarioJpaRepositorio;

@Component
public class DataSeeder implements CommandLineRunner {

    private final IUsuarioJpaRepositorio usuarioRepo;

    public DataSeeder(IUsuarioJpaRepositorio usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public void run(String... args) {

        // ADMIN
        usuarioRepo.findByUsuario("admin").orElseGet(() -> {
            UsuarioJpa admin = new UsuarioJpa();
            admin.setApellido("Jaramillo");
            admin.setCorreo("admin@demo.com");
            admin.setEstado(true);
            admin.setNombre("Jimmy");
            admin.setRol("ADMIN");
            admin.setTelefono("0999999999");
            admin.setUsuario("admin");
            admin.setPasswordHash("$2a$10$p1D7Z4WIUZVIyCr0E2OWf.CmQLZEG4EEfE.wxVHNjvzeY7qrfm3RG");
            return usuarioRepo.save(admin);
        });

        // TECNICO
        usuarioRepo.findByUsuario("tecnico").orElseGet(() -> {
            UsuarioJpa tecnico = new UsuarioJpa();
            tecnico.setApellido("Perez");
            tecnico.setCorreo("tecnico@demo.com");
            tecnico.setEstado(true);
            tecnico.setNombre("Dennis");
            tecnico.setRol("TECNICO");
            tecnico.setTelefono("0988888888");
            tecnico.setUsuario("tecnico");
            tecnico.setPasswordHash("$2a$10$tux39eU/ECgYEV0N5VSgNu8UqbyVXqNeH6UHya32zFtz1BItTO/l.");
            return usuarioRepo.save(tecnico);
        });
    }
}