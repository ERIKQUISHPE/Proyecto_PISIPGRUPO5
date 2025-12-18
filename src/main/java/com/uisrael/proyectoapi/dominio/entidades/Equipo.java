package com.uisrael.proyectoapi.dominio.entidades;

public final class Equipo {

    private final int idEquipo;
    private final int idOrdenes;
    private final String tipo;
    private final String marca;
    private final String modelo;
    private final String serial;
    private final String estadoEquipo;
    private final String observaciones;

    public Equipo(
            int idEquipo,
            int idOrdenes,
            String tipo,
            String marca,
            String modelo,
            String serial,
            String estadoEquipo,
            String observaciones
    ) {
        this.idEquipo = idEquipo;
        this.idOrdenes = idOrdenes;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.serial = serial;
        this.estadoEquipo = estadoEquipo;
        this.observaciones = observaciones;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public int getIdOrdenes() {
        return idOrdenes;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSerial() {
        return serial;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public String toString() {
        return "Equipo [idEquipo=" + idEquipo +
                ", idOrdenes=" + idOrdenes +
                ", tipo=" + tipo +
                ", marca=" + marca +
                ", modelo=" + modelo +
                ", serial=" + serial +
                ", estadoEquipo=" + estadoEquipo +
                ", observaciones=" + observaciones + "]";
    }
}
