package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Material;

public interface IMaterialCasoUso {
	Material guardar(Material material);

	Material buscarPorId(int id);

	List<Material> listarTodos();

	void eliminar(int id);

}
