package com.uisrael.proyectoapi.presentacion.dto.response;

public class EquipoResponseDTO {
	private  int idEquipo;
    private  String tipo;
    private  String marca;
    private  String modelo;
    private  String serial;
    private  OrdenResponseDTO fkOrden;
    private  String estadoEquipo;
    private  String observaciones;
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public OrdenResponseDTO getFkOrden() {
		return fkOrden;
	}
	public void setFkOrden(OrdenResponseDTO fkOrden) {
		this.fkOrden = fkOrden;
	}
	public String getEstadoEquipo() {
		return estadoEquipo;
	}
	public void setEstadoEquipo(String estadoEquipo) {
		this.estadoEquipo = estadoEquipo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
