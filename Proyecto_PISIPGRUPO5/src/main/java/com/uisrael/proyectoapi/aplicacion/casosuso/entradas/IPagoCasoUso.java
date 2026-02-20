package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Pago;

public interface IPagoCasoUso {
	Pago guardar(Pago pago);

	Pago buscarPorId(int idPago);

	List<Pago> listarTodos();

	void eliminar(int idPago);
}
