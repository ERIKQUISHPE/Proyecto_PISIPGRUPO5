package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.UsuarioJpa;

public interface IUsuarioJpaRepositorio extends JpaRepository<UsuarioJpa, Integer>{

}
