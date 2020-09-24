package com.ceiba.adn.carclick.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ceiba.adn.carclick.dominio.servicio.ValidarCampos;
import com.ceiba.adn.carclick.dominio.servicio.ValidarFechas;

public class DetalleReserva {
	
	private static final String EL_ID_DE_LA_RESERVA_ES_REQUERIDO = "El id de la reserva es requerido";
		
	private long id;
	private long idReserva;
	private LocalDateTime fechaEntrega;
	private BigDecimal costo;
	
	public DetalleReserva(long id, long idReserva, LocalDateTime fechaEntrega, BigDecimal costo) {
		ValidarFechas.validarFechaFueraHorarioServicio(fechaEntrega);
		ValidarCampos.esVacio(idReserva, EL_ID_DE_LA_RESERVA_ES_REQUERIDO);
		
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
