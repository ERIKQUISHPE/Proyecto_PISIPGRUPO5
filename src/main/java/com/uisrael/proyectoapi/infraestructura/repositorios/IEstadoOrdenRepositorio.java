package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.EstadoOrdenJpa;

public interface IEstadoOrdenRepositorio extends JpaRepository<EstadoOrdenJpa, Integer> {

}
