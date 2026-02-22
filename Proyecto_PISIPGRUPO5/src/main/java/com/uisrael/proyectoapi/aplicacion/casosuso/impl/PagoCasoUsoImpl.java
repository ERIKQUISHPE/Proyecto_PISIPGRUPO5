package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPagoCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Pago;
import com.uisrael.proyectoapi.dominio.repositorios.IPagoRepositorio;

public class PagoCasoUsoImpl implements IPagoCasoUso {

	    private final IPagoRepositorio repositorio;

	    public PagoCasoUsoImpl(IPagoRepositorio repositorio) {
	        this.repositorio = repositorio;
	    }

	    @Override
	    public Pago guardar(Pago pago) {

	        if (pago.getFkOrden() == null) {
	            throw new IllegalStateException("El pago debe tener una orden asociada");
	        }

	        int idOrden = pago.getFkOrden().getIdOrden();

	        Integer idPago = pago.getIdPago(); 

	        boolean esNuevo = (idPago == null || idPago == 0);

	        if (esNuevo && repositorio.existePagoParaOrden(idOrden)) {
	            throw new IllegalStateException("La orden ya fue cobrada, solo se puede editar o eliminar el pago");
	        }

	        return repositorio.guardar(pago);
	    }

	    @Override
	    public Pago buscarPorId(int idPago) {
	        return repositorio.buscarPorId(idPago)
	                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
	    }

	    @Override
	    public List<Pago> listarTodos() {
	        return repositorio.listarTodos();
	    }

	    @Override
	    public void eliminar(int idPago) {
	        repositorio.eliminar(idPago);
	    }
	    
	    @Override
	    public Optional<Pago> buscarPorOrden(int idOrden) {
	      return repositorio.buscarPorOrden(idOrden);
	    }
	}


