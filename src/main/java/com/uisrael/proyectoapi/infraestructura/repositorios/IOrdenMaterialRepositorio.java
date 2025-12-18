package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.OrdenMaterialJpa;

public interface IOrdenMaterialRepositorio extends JpaRepository<OrdenMaterialJpa, Integer> {
}
