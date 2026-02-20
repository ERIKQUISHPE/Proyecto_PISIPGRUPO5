package com.uisrael.proyectoapi.dominio.entidades;

public final class Accesorio {

    private final int idAccesorio;
    private final String descripcion;
    private final boolean incluido;
    private Equipo fkEquipo;
    
	public Accesorio(int idAccesorio, String descripcion, boolean incluido, Equipo fkEquipo) {
		this.idAccesorio = idAccesorio;
		this.descripcion = descripcion;
		this.incluido = incluido;
		this.fkEquipo = fkEquipo;
	}

	public Equipo getFkEquipo() {
		return fkEquipo;
	}

	public void setFkEquipo(Equipo fkEquipo) {
		this.fkEquipo = fkEquipo;
	}

	public int getIdAccesorio() {
		return idAccesorio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isIncluido() {
		return incluido;
	}

	@Override
	public String toString() {
		return "Accesorio [idAccesorio=" + idAccesorio + ", descripcion=" + descripcion + ", incluido=" + incluido
				+ ", fkEquipo=" + fkEquipo + "]";
	}

	
}
