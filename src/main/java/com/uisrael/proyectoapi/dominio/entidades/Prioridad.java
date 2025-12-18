package com.uisrael.proyectoapi.dominio.entidades;

public final class Prioridad {

    private final int idPrioridad;
    private final String nombre;

    public Prioridad(int idPrioridad, String nombre) {
        this.idPrioridad = idPrioridad;
        this.nombre = nombre;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Prioridad [idPrioridad=" + idPrioridad + ", nombre=" + nombre + "]";
    }
}
