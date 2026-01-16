package com.uisrael.proyectoapi.presentacion.dto.response;

public class AccesorioResponseDTO {
	private  int idAccesorio;
    private  String descripcion;
    private  boolean incluido;
    
	public int getIdAccesorio() {
		return idAccesorio;
	}
	public void setIdAccesorio(int idAccesorio) {
		this.idAccesorio = idAccesorio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isIncluido() {
		return incluido;
	}
	public void setIncluido(boolean incluido) {
		this.incluido = incluido;
	}
}
