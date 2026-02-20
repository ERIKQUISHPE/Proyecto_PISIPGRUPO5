package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "accion_reparacion_materiales")
public class AccionReparacionMaterialJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAccionMaterial;

    private int cantidad;

    private BigDecimal costoCompra;
    private BigDecimal costoVenta;

    @ManyToOne
    @JoinColumn(name = "fkAccion")
    private AccionReparacionJpa fkAccion;

    @ManyToOne
    @JoinColumn(name = "fkMaterial")
    private MaterialJpa fkMaterial;
}
