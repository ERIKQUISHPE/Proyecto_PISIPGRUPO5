package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;	
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "entregas")
public class EntregaJpa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntrega;

    @OneToOne
    @JoinColumn(name = "fkOrden")
    private OrdenJpa fkOrden;

    private String recibidoPor;  

    @ManyToOne
    @JoinColumn(name = "entregado_por_id")
    private UsuarioJpa entregadoPor; 

    private LocalDateTime fechaEntrega;
    private String notas;
}
