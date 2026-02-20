package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Cliente;
import com.uisrael.proyectoapi.dominio.repositorios.IClienteRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ClienteJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IClienteJpaRepositorio;

public class ClienteRepositorioImpl implements IClienteRepositorio{

	private final IClienteJpaRepositorio jpaRepositorio;
	private final IClienteJpaMapper entityMapper;
	
	public ClienteRepositorioImpl(IClienteJpaRepositorio jpaRepositorio, IClienteJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		ClienteJpa entity= entityMapper.toEntity(cliente);
		ClienteJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Cliente> buscarPorId(int idCliente) {
		return jpaRepositorio.findById(idCliente).map(entityMapper::toDomain);
	}

	@Override
	public List<Cliente> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCliente) {
		jpaRepositorio.deleteById(idCliente);
	}
}
