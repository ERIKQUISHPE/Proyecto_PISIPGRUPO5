package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Pago;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PagoJpa;

@Mapper (componentModel = "spring")
public interface IPagoJpaMapper {
	
	Pago toDomain(PagoJpa entity);
	
	PagoJpa toEntity(Pago pago);
}
