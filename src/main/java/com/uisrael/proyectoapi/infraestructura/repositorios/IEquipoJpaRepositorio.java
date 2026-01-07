package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.EquipoJpa;

public interface IEquipoJpaRepositorio extends JpaRepository<EquipoJpa, Integer> {

}
