package com.uisrael.proyectoapi.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ClienteJpa;

public interface IClienteJpaRepositorio extends JpaRepository<ClienteJpa, Integer>{

	@Query("Select cliente From clienteJpa cli")
	List<ClienteJpa> listarSQL();
	
	
}
