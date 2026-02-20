package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.entidades.OrdenInterna;
import com.uisrael.proyectoapi.presentacion.dto.request.OrdenInternaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.OrdenInternaResponseDTO;

@Mapper(componentModel = "spring")
public interface IOrdenInternaDtoMapper {

    OrdenInterna toDomain(OrdenInternaRequestDTO dto);

    @Mapping(target = "idOrden", source = "fkOrden", qualifiedByName = "mapIdOrden")
    @Mapping(target = "textoOrden", source = "fkOrden", qualifiedByName = "mapTextoOrden")
    OrdenInternaResponseDTO toResponseDto(OrdenInterna ordenInterna);

    @Named("mapIdOrden")
    default Integer mapIdOrden(Orden orden) {
        return (orden == null) ? null : orden.getIdOrden();
    }

    @Named("mapTextoOrden")
    default String mapTextoOrden(Orden orden) {
        return (orden == null) ? null : ("Orden #" + orden.getIdOrden());
    }
}
