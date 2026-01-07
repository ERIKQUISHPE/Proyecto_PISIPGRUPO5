package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ProveedorJpa;

public interface IProveedorJpaRepositorio extends JpaRepository<ProveedorJpa, Integer>{

}