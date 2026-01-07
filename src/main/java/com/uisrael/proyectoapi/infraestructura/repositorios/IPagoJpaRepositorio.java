package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PagoJpa;

public interface IPagoJpaRepositorio extends JpaRepository<PagoJpa, Integer> {

}
