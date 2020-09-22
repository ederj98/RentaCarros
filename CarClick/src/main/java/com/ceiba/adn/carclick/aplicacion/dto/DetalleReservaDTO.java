package com.ceiba.adn.carclick.aplicacion.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalleReservaDTO {

	private long id;
	private long idReserva;
	private LocalDateTime fechaEntrega;
	private BigDecimal costo;
	
	@JsonCreator
	public DetalleReservaDTO(@JsonProperty("id") long id, @JsonProperty("idReserva") long idReserva, 
			@JsonProperty("fechaEntrega") LocalDateTime fechaEntrega, @JsonProperty("costo") BigDecimal costo) {
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
