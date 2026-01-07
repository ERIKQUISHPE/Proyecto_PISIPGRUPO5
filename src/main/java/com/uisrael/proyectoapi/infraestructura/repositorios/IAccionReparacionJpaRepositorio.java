package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionJpa;

public interface IAccionReparacionJpaRepositorio extends JpaRepository<AccionReparacionJpa, Integer> {

}
