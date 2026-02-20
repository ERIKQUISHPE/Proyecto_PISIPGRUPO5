package com.uisrael.proyectoapi.infraestructura.repositorios;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.UsuarioJpa;

public interface IUsuarioJpaRepositorio extends JpaRepository<UsuarioJpa, Integer> {

    Optional<UsuarioJpa> findByUsuario(String usuario);
}
