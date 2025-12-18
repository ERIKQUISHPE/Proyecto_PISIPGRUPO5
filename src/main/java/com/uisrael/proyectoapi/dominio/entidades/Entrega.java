package com.uisrael.proyectoapi.dominio.entidades;

import java.time.LocalDateTime;

public final class Entrega {

    private final int idEntrega;
    private final int idOrdenes;
    private final int entregadoPor;
    private final int recibidoPor;
    private final LocalDateTime fechaEntrega;
    private final String notas;

    public Entrega(
            int idEntrega,
            int idOrdenes,
            int entregadoPor,
            int recibidoPor,
            LocalDateTime fechaEntrega,
            String notas
    ) {
        this.idEntrega = idEntrega;
        this.idOrdenes = idOrdenes;
        this.entregadoPor = entregadoPor;
        this.recibidoPor = recibidoPor;
        this.fechaEntrega = fechaEntrega;
        this.notas = notas;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public int getIdOrdenes() {
        return idOrdenes;
    }

    public int getEntregadoPor() {
        return entregadoPor;
    }

    public int getRecibidoPor() {
        return recibidoPor;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public String getNotas() {
        return notas;
    }

    @Override
    public String toString() {
        return "Entrega [idEntrega=" + idEntrega +
                ", idOrdenes=" + idOrdenes +
                ", entregadoPor=" + entregadoPor +
                ", recibidoPor=" + recibidoPor +
                ", fechaEntrega=" + fechaEntrega +
                ", notas=" + notas + "]";
    }
}
