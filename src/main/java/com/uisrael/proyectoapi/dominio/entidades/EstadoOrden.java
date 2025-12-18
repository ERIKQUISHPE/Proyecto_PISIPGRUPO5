package com.uisrael.proyectoapi.dominio.entidades;

public final class EstadoOrden {

    private final int idEstado;
    private final String nombre;

    public EstadoOrden(int idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "EstadoOrden [idEstado=" + idEstado + ", nombre=" + nombre + "]";
    }
}
