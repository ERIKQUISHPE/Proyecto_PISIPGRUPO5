package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenJpa;

public interface IOrdenJpaRepositorio extends JpaRepository<OrdenJpa, Integer>{

}
