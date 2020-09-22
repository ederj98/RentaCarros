package com.ceiba.adn.carclick.testdatabuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ceiba.adn.carclick.aplicacion.dto.DetalleReservaDTO;

public class DetalleReservaDTOTestDataBuilder {

	public long id;
	public long idReserva;
	public LocalDateTime fechaEntrega;
	public BigDecimal costo;
	
	public DetalleReservaDTOTestDataBuilder(long id, long idReserva, LocalDateTime fechaEntrega, BigDecimal costo) {
		this.id = id;
		this.idReserva = idReserva;
		this.fechaEntrega = fechaEntrega;
		this.costo = costo;
	}

	public DetalleReservaDTOTestDataBuilder() {
		this.id = 1L;
		this.idReserva = 1L;
		this.fechaEntrega = LocalDateTime.of(2020, 9, 10, 14, 0);
		this.costo = new BigDecimal(0);
	}
	
	public DetalleReservaDTO build() {
		return new DetalleReservaDTO(id, idReserva, fechaEntrega, costo);
	}
	
	public DetalleReservaDTOTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public DetalleReservaDTOTestDataBuilder conIdReserva(long idReserva) {
		this.idReserva = idReserva;
		return this;
	}
	
	public DetalleReservaDTOTestDataBuilder conFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		return this;
	}
	
	public DetalleReservaDTOTestDataBuilder conCosto(BigDecimal costo) {
		this.costo = costo;
		return this;
	}
}
