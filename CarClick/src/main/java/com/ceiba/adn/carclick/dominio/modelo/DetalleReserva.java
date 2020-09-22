package com.ceiba.adn.carclick.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DetalleReserva {
	
	private long id;
	private long idReserva;
	private LocalDateTime fechaEntrega;
	private BigDecimal costo;
	
	public DetalleReserva(long id, long idReserva, LocalDateTime fechaEntrega, BigDecimal costo) {
		this.id = id;
		this.idReserva = idReserva;
		this.fechaEntrega = fechaEntrega;
		this.costo = costo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
}
