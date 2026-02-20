package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.AccionReparacionMaterial;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.AccionReparacionMaterialJpa;

@Mapper(componentModel = "spring")
public interface IAccionReparacionMaterialJpaMapper {

    AccionReparacionMaterial toDomain(AccionReparacionMaterialJpa entity);

    @Mapping(target = "fkAccion", ignore = true)
    @Mapping(target = "fkMaterial", ignore = true)
    AccionReparacionMaterialJpa toEntity(AccionReparacionMaterial domain);
}
