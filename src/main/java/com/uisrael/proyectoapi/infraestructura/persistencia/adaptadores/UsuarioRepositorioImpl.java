package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Usuario;
import com.uisrael.proyectoapi.dominio.repositorios.IUsuarioRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.UsuarioJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IUsuarioJpaRepositorio;

public class UsuarioRepositorioImpl implements IUsuarioRepositorio{

	//dependencias
	private final IUsuarioJpaRepositorio jpaRepositorio;
	private final IUsuarioJpaMapper entityMapper;
	
	//constructor
	public UsuarioRepositorioImpl(IUsuarioJpaRepositorio jpaRepositorio, IUsuarioJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		UsuarioJpa entity= entityMapper.toEntity(usuario);
		UsuarioJpa guardado=jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Usuario> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Usuario> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
