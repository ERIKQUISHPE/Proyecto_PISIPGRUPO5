package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.EntregaJpa;

public interface IEntregaJpaRepositorio
        extends JpaRepository<EntregaJpa, Integer> {

}
