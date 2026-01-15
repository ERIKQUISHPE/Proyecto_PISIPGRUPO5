package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;	
import org.springframework.context.annotation.Configuration;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IAccesorioCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IAccionReparacionCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IClienteCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEntregaCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEquipoCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IEstadoOrdenCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IMaterialCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenInternaCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IOrdenMaterialCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPagoCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPrioridadCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IProveedorCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IUsuarioCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.AccesorioCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.AccionReparacionCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.ClienteCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.EntregaCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.EquipoCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.EstadoOrdenCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.MaterialCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.OrdenCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.OrdenInternaCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.OrdenMaterialCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.PagoCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.PrioridadCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.ProveedorCasoUsoImpl;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.UsuarioCasoUsoImpl;
import com.uisrael.proyectoapi.dominio.repositorios.IAccesorioRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IAccionReparacionRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IClienteRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IEntregaRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IEquipoRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IEstadoOrdenRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IMaterialRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenInternaRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenMaterialRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IOrdenRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IPagoRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IPrioridadRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IProveedorRepositorio;
import com.uisrael.proyectoapi.dominio.repositorios.IUsuarioRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.AccesorioRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.AccionReparacionRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.EntregaRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.EquipoRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.EstadoOrdenRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.MaterialRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.OrdenInternaRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.OrdenMaterialRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.OrdenRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.PagoRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.PrioridadRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.ProveedorRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IAccesorioJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IAccionReparacionJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IEntregaJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IEquipoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IEstadoOrdenJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IMaterialJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IOrdenInternaJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IOrdenJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IOrdenMaterialJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IPagoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IPrioridadJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IProveedorJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccesorioJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IAccionReparacionJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IClienteJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IEntregaJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IEquipoJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IEstadoOrdenJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IMaterialJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenInternaJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IOrdenMaterialJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IPagoJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IPrioridadJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IProveedorJpaRepositorio;
import com.uisrael.proyectoapi.infraestructura.repositorios.IUsuarioJpaRepositorio;

@Configuration
public class AplicacionConfig {

	@Bean
	IClienteRepositorio clienteRepositorio(IClienteJpaRepositorio jpaRepository, IClienteJpaMapper mapper) {
		return new ClienteRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IClienteCasoUso clienteCasoUso(IClienteRepositorio repositorio) {
		return new ClienteCasoUsoImpl(repositorio);
	}

	// Orden
	@Bean
	IOrdenRepositorio ordenRepositorio(IOrdenJpaRepositorio jpaRepository, IOrdenJpaMapper mapper) {
		return new OrdenRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IOrdenCasoUso ordenCasoUso(IOrdenRepositorio repositorio) {
		return new OrdenCasoUsoImpl(repositorio);
	}

	// Accesorio
	@Bean
	IAccesorioRepositorio accesorioRepositorio(IAccesorioJpaRepositorio jpaRepository, IAccesorioJpaMapper mapper) {
		return new AccesorioRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IAccesorioCasoUso accesorioCasoUso(IAccesorioRepositorio repositorio) {
		return new AccesorioCasoUsoImpl(repositorio);
	}

	// AccionReparacion
	@Bean
	IAccionReparacionRepositorio accionReparacionRepositorio(IAccionReparacionJpaRepositorio jpaRepository,
			IAccionReparacionJpaMapper mapper) {
		return new AccionReparacionRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IAccionReparacionCasoUso accionReparacionCasoUso(IAccionReparacionRepositorio repositorio) {
		return new AccionReparacionCasoUsoImpl(repositorio);
	}

	// Entrega
	@Bean
	IEntregaRepositorio entregaRepositorio(IEntregaJpaRepositorio jpaRepository, IEntregaJpaMapper mapper) {
		return new EntregaRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IEntregaCasoUso entregaCasoUso(IEntregaRepositorio repositorio) {
		return new EntregaCasoUsoImpl(repositorio);
	}

	// Equipo
	@Bean
	IEquipoRepositorio equipoRepositorio(IEquipoJpaRepositorio jpaRepository, IEquipoJpaMapper mapper) {
		return new EquipoRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IEquipoCasoUso equipoCasoUso(IEquipoRepositorio repositorio) {
		return new EquipoCasoUsoImpl(repositorio);
	}

	// Estado Orden
	@Bean
	IEstadoOrdenRepositorio estadoOrdenRepositorio(IEstadoOrdenJpaRepositorio jpaRepository,
			IEstadoOrdenJpaMapper mapper) {
		return new EstadoOrdenRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IEstadoOrdenCasoUso estadoOrdenCasoUso(IEstadoOrdenRepositorio repositorio) {
		return new EstadoOrdenCasoUsoImpl(repositorio);
	}

	// Material
	@Bean
	IMaterialRepositorio materialRepositorio(IMaterialJpaRepositorio jpaRepository, IMaterialJpaMapper mapper) {
		return new MaterialRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IMaterialCasoUso materialCasoUso(IMaterialRepositorio repositorio) {
		return new MaterialCasoUsoImpl(repositorio);
	}

	// OrdenInterna
	@Bean
	IOrdenInternaRepositorio ordenInternaRepositorio(IOrdenInternaJpaRepositorio jpaRepository,
			IOrdenInternaJpaMapper mapper) {
		return new OrdenInternaRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IOrdenInternaCasoUso ordenInternaCasoUso(IOrdenInternaRepositorio repositorio) {
		return new OrdenInternaCasoUsoImpl(repositorio);
	}

	// OrdenMaterial
	@Bean
	IOrdenMaterialRepositorio ordenMaterialRepositorio(IOrdenMaterialJpaRepositorio jpaRepository,
			IOrdenMaterialJpaMapper mapper) {
		return new OrdenMaterialRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IOrdenMaterialCasoUso ordenMaterialCasoUso(IOrdenMaterialRepositorio repositorio) {
		return new OrdenMaterialCasoUsoImpl(repositorio);
	}

	// Pago
	@Bean
	IPagoRepositorio pagoRepositorio(IPagoJpaRepositorio jpaRepository, IPagoJpaMapper mapper) {
		return new PagoRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IPagoCasoUso pagoCasoUso(IPagoRepositorio repositorio) {
		return new PagoCasoUsoImpl(repositorio);
	}

	// Prioridad
	@Bean
	IPrioridadRepositorio prioridadRepositorio(IPrioridadJpaRepositorio jpaRepository, IPrioridadJpaMapper mapper) {
		return new PrioridadRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IPrioridadCasoUso prioridadCasoUso(IPrioridadRepositorio repositorio) {
		return new PrioridadCasoUsoImpl(repositorio);
	}

	// Proveedor
	@Bean
	IProveedorRepositorio proveedorRepositorio(IProveedorJpaRepositorio jpaRepository, IProveedorJpaMapper mapper) {
		return new ProveedorRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IProveedorCasoUso proveedorCasoUso(IProveedorRepositorio repositorio) {
		return new ProveedorCasoUsoImpl(repositorio);
	}

	// Usuario
	@Bean
	IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaRepositorio jpaRepository, IUsuarioJpaMapper mapper) {
		return new UsuarioRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IUsuarioCasoUso usuarioCasoUso(IUsuarioRepositorio repositorio) {
		return new UsuarioCasoUsoImpl(repositorio);
	}
}
