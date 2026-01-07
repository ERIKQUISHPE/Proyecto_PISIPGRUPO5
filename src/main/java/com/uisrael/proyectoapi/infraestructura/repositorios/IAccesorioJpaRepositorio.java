package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccesorioJpa;

public interface IAccesorioJpaRepositorio extends JpaRepository<AccesorioJpa, Integer> {

}
