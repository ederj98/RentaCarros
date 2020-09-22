package com.ceiba.adn.carclick.testdatabuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ceiba.adn.carclick.dominio.modelo.DetalleReserva;

public class DetalleReservaTestDataBuilder {
	
	public long id;
	public long idReserva;
	public LocalDateTime fechaEntrega;
	public BigDecimal costo;
	
	public DetalleReservaTestDataBuilder() {
		this.id = 1L;
		this.idReserva = 1L;
		this.fechaEntrega = LocalDateTime.of(2020, 9, 10, 14, 0);
		this.costo = new BigDecimal(0);
	}
	
	public DetalleReserva build() {
		return new DetalleReserva(id, idReserva, fechaEntrega, costo);
	}
	
	public DetalleReservaTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public DetalleReservaTestDataBuilder conIdReserva(long idReserva) {
		this.idReserva = idReserva;
		return this;
	}
	
	public DetalleReservaTestDataBuilder conFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		return this;
	}
	
	public DetalleReservaTestDataBuilder conCosto(BigDecimal costo) {
		this.costo = costo;
		return this;
	}
}
