package com.ceiba.adn.carclick.testdatabuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.DetalleReservaEntidad;
import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ReservaEntidad;

public class DetalleReservaEntidadTestDataBuilder {

	public long id;
	private ReservaEntidad reserva;
	public LocalDateTime fechaEntrega;
	public BigDecimal costo;
	
	public DetalleReservaEntidadTestDataBuilder(long id, ReservaEntidad reserva, LocalDateTime fechaEntrega,
			BigDecimal costo) {
		super();
		this.id = id;
		this.reserva = reserva;
		this.fechaEntrega = fechaEntrega;
		this.costo = costo;
	}

	public DetalleReservaEntidadTestDataBuilder() {
		this.id = 1L;
		this.reserva = new ReservaEntidadTestDataBuilder().build();
		this.fechaEntrega = LocalDateTime.of(2020, 9, 10, 14, 0);
		this.costo = new BigDecimal(0);
	}
	
	public DetalleReservaEntidad build() {
		return new DetalleReservaEntidad(id, reserva, fechaEntrega, costo);
	}
	
	public DetalleReservaEntidadTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public DetalleReservaEntidadTestDataBuilder conIdReserva(long idReserva) {
		ReservaEntidad reserva = new ReservaEntidadTestDataBuilder().conId(idReserva).build();
		this.reserva = reserva;
		return this;
	}
	
	public DetalleReservaEntidadTestDataBuilder conFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		return this;
	}
	
	public DetalleReservaEntidadTestDataBuilder conCosto(BigDecimal costo) {
		this.costo = costo;
		return this;
	}
}
