package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;		
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orden")
public class OrdenJpa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrden;
	
	@CreationTimestamp
	@Column(name = "fecha_ingreso", nullable = false, updatable = false)
	private LocalDateTime fechaIngreso;
	
	@CreationTimestamp
	@Column(name = "fecha_salida", nullable = false, updatable = false)
	private LocalDateTime fechaSalida;
	
	private String detalleProblema;
	private String observaciones;
	private BigDecimal totalCobro;
	private boolean pagado;
	private String estadoOrden;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	private ClienteJpa fkCliente;
		
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	private UsuarioJpa fkUsuario;
	
}
