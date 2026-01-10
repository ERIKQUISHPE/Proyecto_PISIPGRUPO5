package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ordenes")
public class OrdenJpa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrden;
	private String codigoOrden;
	private int idCliente;
	private int idPrioridad;
	private int idEstado;
	private int tecnicoAsignado;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private String detalleProblema;
	private String observaciones;
	private BigDecimal totalCobro;
	private boolean pagado;
	@Column(name = "creado en",length = 80)
	private LocalDateTime creadoEn;
	private boolean estado; //true: activo - false: eliminado
}
