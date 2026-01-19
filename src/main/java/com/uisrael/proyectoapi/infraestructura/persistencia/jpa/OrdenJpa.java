package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;	
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private String codigoOrden;
	@CreationTimestamp
	@Column(name = "fecha_ingreso", nullable = false, updatable = false)
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private String detalleProblema;
	private String observaciones;
	private BigDecimal totalCobro;
	private boolean pagado;
	@CreationTimestamp
	@Column(name = "creado_en", nullable = false, updatable = false)
	private LocalDateTime creadoEn;
	private boolean estado; //true: activo - false: eliminado
	
	@ManyToOne
	@JoinColumn(name = "fkCliente")
	private ClienteJpa fkCliente;
	
	@ManyToOne
	@JoinColumn(name = "fkPrioridad")
	private PrioridadJpa fkPrioridad;
	
	@ManyToOne
	@JoinColumn(name = "fkEstadoOrden")
	private EstadoOrdenJpa fkEstadoOrden;
	
	@ManyToOne
	@JoinColumn(name = "fkUsuario")
	private UsuarioJpa fkUsuario;
	
	@OneToMany(mappedBy = "fkOrden")
    private List<EquipoJpa> equipo;
	
	@OneToMany(mappedBy = "fkOrden")
    private List<PagoJpa> pago;
	
	@OneToMany(mappedBy = "fkOrden")
    private List<OrdenInternaJpa> orden_interna;
	
	@OneToMany(mappedBy = "fkOrden")
    private List<EntregaJpa> entrega;
	
	@OneToMany(mappedBy = "fkOrden")
    private List<MaterialJpa> material;
	
	@OneToMany(mappedBy = "fkOrden")
    private List<AccionReparacionJpa> accion_reparacion;
	
	@OneToMany(mappedBy = "fkOrden")
    private List<OrdenMaterialJpa> orden_material;
}
