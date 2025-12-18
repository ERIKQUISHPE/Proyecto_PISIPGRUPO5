package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pagos")
public class PagoJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    private int idOrdenes;
    private BigDecimal monto;
    private String metodoPago;
    private LocalDateTime fechaPago;
    private int registradoPor;
}
