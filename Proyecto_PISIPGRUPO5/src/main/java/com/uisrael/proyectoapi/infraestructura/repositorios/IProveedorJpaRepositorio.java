package com.uisrael.proyectoapi.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ProveedorJpa;

public interface IProveedorJpaRepositorio extends JpaRepository<ProveedorJpa, Integer>{
	
	List<ProveedorJpa> findByEstadoTrue();

    boolean existsByProveedorIgnoreCase(String proveedor);   	
}
