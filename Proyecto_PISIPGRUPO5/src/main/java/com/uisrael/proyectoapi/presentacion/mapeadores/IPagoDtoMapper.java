package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.uisrael.proyectoapi.dominio.entidades.Orden;
import com.uisrael.proyectoapi.dominio.entidades.Pago;
import com.uisrael.proyectoapi.presentacion.dto.request.PagoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.PagoResponseDTO;

@Mapper(componentModel = "spring")
public interface IPagoDtoMapper {

    // ✅ MANUAL, usando tu constructor real
    default Pago toDomain(PagoRequestDTO dto) {
        if (dto == null) return null;

        int idPago = 0; // el id lo define el controlador en PUT, en POST será 0
        return new Pago(
                idPago,
                dto.getMonto(),
                dto.getMetodoPago(),
                dto.getFechaPago(),
                dto.getRegistradoPor(),
                null // fkOrden se setea en el controlador
        );
    }

    @Mapping(target = "idOrden", source = "fkOrden", qualifiedByName = "mapIdOrden")
    @Mapping(target = "textoOrden", source = "fkOrden", qualifiedByName = "mapTextoOrden")
    PagoResponseDTO toResponseDto(Pago pago);

    @Named("mapIdOrden")
    default Integer mapIdOrden(Orden orden) {
        return (orden == null) ? null : orden.getIdOrden();
    }

    @Named("mapTextoOrden")
    default String mapTextoOrden(Orden orden) {
        return (orden == null) ? null : ("Orden #" + orden.getIdOrden());
    }
}