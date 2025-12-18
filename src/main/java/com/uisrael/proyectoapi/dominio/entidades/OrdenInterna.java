package com.uisrael.proyectoapi.dominio.entidades;

import java.time.LocalDateTime;

public final class OrdenInterna {

    private final int idOrdenInterna;
    private final int idOrdenes;
    private final int tecnicoId;
    private final int estadoId;
    private final String diagnostico;
    private final String observaciones;
    private final int creadoPor;
    private final LocalDateTime creadoEn;

    public OrdenInterna(
            int idOrdenInterna,
            int idOrdenes,
            int tecnicoId,
            int estadoId,
            String diagnostico,
            String observaciones,
            int creadoPor,
            LocalDateTime creadoEn
    ) {
        this.idOrdenInterna = idOrdenInterna;
        this.idOrdenes = idOrdenes;
        this.tecnicoId = tecnicoId;
        this.estadoId = estadoId;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
        this.creadoPor = creadoPor;
        this.creadoEn = creadoEn;
    }

    public int getIdOrdenInterna() {
        return idOrdenInterna;
    }

    public int getIdOrdenes() {
        return idOrdenes;
    }

    public int getTecnicoId() {
        return tecnicoId;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public int getCreadoPor() {
        return creadoPor;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    @Override
    public String toString() {
        return "OrdenInterna [idOrdenInterna=" + idOrdenInterna +
                ", idOrdenes=" + idOrdenes +
                ", tecnicoId=" + tecnicoId +
                ", estadoId=" + estadoId +
                ", diagnostico=" + diagnostico +
                ", observaciones=" + observaciones +
                ", creadoPor=" + creadoPor +
                ", creadoEn=" + creadoEn + "]";
    }
}
