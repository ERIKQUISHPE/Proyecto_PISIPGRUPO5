package com.uisrael.proyectoapi.dominio.entidades;

public final class Accesorio {

    private final int idAccesorio;
    private final int idEquipo;
    private final String descripcion;
    private final boolean incluido;

    public Accesorio(
            int idAccesorio,
            int idEquipo,
            String descripcion,
            boolean incluido
    ) {
        this.idAccesorio = idAccesorio;
        this.idEquipo = idEquipo;
        this.descripcion = descripcion;
        this.incluido = incluido;
    }

    public int getIdAccesorio() {
        return idAccesorio;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isIncluido() {
        return incluido;
    }

    @Override
    public String toString() {
        return "Accesorio [idAccesorio=" + idAccesorio +
                ", idEquipo=" + idEquipo +
                ", descripcion=" + descripcion +
                ", incluido=" + incluido + "]";
    }
}
