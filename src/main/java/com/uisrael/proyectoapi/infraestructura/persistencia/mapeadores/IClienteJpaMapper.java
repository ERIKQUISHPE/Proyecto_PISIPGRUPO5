package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.Cliente;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ClienteJpa;

@Mapper(componentModel = "spring")
public interface IClienteJpaMapper {

    Cliente toDomain(ClienteJpa entity);

    @Mapping(target = "creadoEn", ignore = true)
    ClienteJpa toEntity(Cliente cliente);
}
