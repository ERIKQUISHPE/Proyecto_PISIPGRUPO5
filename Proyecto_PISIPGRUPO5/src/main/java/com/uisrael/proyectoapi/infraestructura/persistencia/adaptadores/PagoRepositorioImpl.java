package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Pago;
import com.uisrael.proyectoapi.dominio.repositorios.IPagoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PagoJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IPagoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IPagoJpaRepositorio;

public class PagoRepositorioImpl implements IPagoRepositorio{

	private final IPagoJpaRepositorio jpaRepositorio;
	private final IPagoJpaMapper entityMapper;
	
	public PagoRepositorioImpl(IPagoJpaRepositorio jpaRepositorio, IPagoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Pago guardar(Pago pago) {
		PagoJpa entity= entityMapper.toEntity(pago);
		PagoJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Pago> buscarPorId(int idPago) {
		return jpaRepositorio.findById(idPago).map(entityMapper::toDomain);
	}

	@Override
	public List<Pago> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idPago) {
		jpaRepositorio.deleteById(idPago);
	}
	
	@Override
	public boolean existePagoParaOrden(int idOrden) {
	    return jpaRepositorio.existsByFkOrden_IdOrden(idOrden);
	}
	
	@Override
	public Optional<Pago> buscarPorOrden(int idOrden) {
	  return jpaRepositorio.findFirstByFkOrden_IdOrden(idOrden)
	      .map(entityMapper::toDomain);
	}

}
