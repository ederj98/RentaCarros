package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLE_RESERVA")
public class DetalleReservaEntidad {
	
	public long getId() {
		return id;
	}

	public ReservaEntidad getReserva() {
		return reserva;
	}

	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ID_RESERVA", referencedColumnName = "id")
	private ReservaEntidad reserva;
	
	@Column(name = "FECHA_ENTREGA")
	private LocalDateTime fechaEntrega;
	
	@Column(name = "COSTO")
	private BigDecimal costo;
	
	public DetalleReservaEntidad() {}
	
	public DetalleReservaEntidad(long id, ReservaEntidad reserva, LocalDateTime fechaEntrega, BigDecimal costo) {
		this.id = id;
		this.reserva = reserva;
		this.fechaEntrega = fechaEntrega;
		this.costo = costo;
	}
}
