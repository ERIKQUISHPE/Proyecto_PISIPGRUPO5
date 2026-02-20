package com.uisrael.proyectoapi.infraestructura.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;


import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenInternaJpa;

public interface IOrdenInternaJpaRepositorio extends JpaRepository<OrdenInternaJpa, Integer> {

	
	Boolean existsByFkOrden_IdOrden(Integer idOrden);
	void deleteByFkOrden_IdOrden(Integer idOrden);
	
}
