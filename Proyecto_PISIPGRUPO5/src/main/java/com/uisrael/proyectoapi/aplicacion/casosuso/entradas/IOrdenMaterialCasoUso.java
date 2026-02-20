package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.OrdenMaterial;

public interface IOrdenMaterialCasoUso {
	OrdenMaterial guardar(OrdenMaterial ordenMaterial);

	OrdenMaterial buscarPorId(int idOrdenMaterial);

	List<OrdenMaterial> listarTodos();

	void eliminar(int idOrdenMaterial);
}
