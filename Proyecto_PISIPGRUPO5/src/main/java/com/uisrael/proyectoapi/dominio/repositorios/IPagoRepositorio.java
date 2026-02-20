package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Pago;

public interface IPagoRepositorio {

	Pago guardar(Pago pago);
	
	Optional<Pago> buscarPorId(int idPago);
	
	List<Pago> listarTodos();
	
	void eliminar(int idPago);
	
	boolean existePagoParaOrden(int idOrden);

}
