package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IClienteCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.ClienteCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.OrdenCasoUsoImpl;
import com.uisrael.proyectoapi.dominio.repositorios.IClienteRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.OrdenRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IOrdenJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IClienteJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenJpaRepositorio;

@Configuration
public class ClienteConfig {
	
	@Bean
	IClienteRepositorio clienteRepositorio(IClienteJpaRepositorio jpaRepository, IClienteJpaMapper mapper) {
		return new ClienteRepositorioImpl(jpaRepository, mapper);
	}
	
	@Bean
	IClienteCasoUso clienteCasoUso(IClienteRepositorio repositorio) {
		return new ClienteCasoUsoImpl(repositorio);
	}
	
	@Bean
	IOrdenRepositorio ordenRepositorio(IOrdenJpaRepositorio jpaRepository, IOrdenJpaMapper mapper) {
		return new OrdenRepositorioImpl(jpaRepository, mapper);
	}
	
	@Bean
	IOrdenCasoUso ordenCasoUso(IOrdenRepositorio repositorio) {
		return new OrdenCasoUsoImpl(repositorio);
	}
}