package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLES_RESERVAS")
public class DetalleReservaEntidad {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@Column(name = "ID_RESERVA")
	private long idReserva;
	
	@Column(name = "FECHA_ENTREGA")
	private LocalDateTime fechaEntrega;
	
	@Column(name = "COSTO")
	private BigDecimal costo;
	
	public DetalleReservaEntidad() {}
	
	public DetalleReservaEntidad(long id, long idReserva, LocalDateTime fechaEntrega, BigDecimal costo) {
		this.id = id;
		this.idReserva = idReserva;
		this.fechaEntrega = fechaEntrega;
		this.costo = costo;
	}

	public long getId() {
		return id;
	}

	public long getIdReserva() {
		return idReserva;
	}

	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}

	public BigDecimal getCosto() {
		return costo;
	}
}
