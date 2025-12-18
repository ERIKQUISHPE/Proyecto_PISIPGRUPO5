package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenInternaJpa;

public interface IOrdenInternaRepositorio extends JpaRepository<OrdenInternaJpa, Integer> {

}
