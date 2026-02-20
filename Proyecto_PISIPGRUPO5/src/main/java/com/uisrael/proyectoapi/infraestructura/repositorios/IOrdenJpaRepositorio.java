package com.uisrael.proyectoapi.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.projection.IOrdenDashboardProjection;

public interface IOrdenJpaRepositorio extends JpaRepository<OrdenJpa, Integer> {

  @Query("""
    select 
      o.idOrden as idOrden,
      o.fechaIngreso as fechaIngreso,
      0 as idEstado,
      o.estadoOrden as nombreEstado,
      true as estado
    from OrdenJpa o
  """)
  List<IOrdenDashboardProjection> dashboardOrdenes();
  
  @Query("""
		  SELECT o FROM OrdenJpa o
		  WHERE o.idOrden NOT IN (
		    SELECT e.fkOrden.idOrden FROM EntregaJpa e
		  )
		""")
		List<OrdenJpa> listarOrdenesDisponibles();
  
}
