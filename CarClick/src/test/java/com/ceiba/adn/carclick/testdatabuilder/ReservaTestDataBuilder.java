package com.ceiba.adn.carclick.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.adn.carclick.dominio.modelo.Reserva;

public class ReservaTestDataBuilder {
	
	public long id;
	public long idCliente;
	public long idCarro;
	public LocalDateTime fechaRecogida;
	
	public ReservaTestDataBuilder() {
		this.id = 1L;
		this.idCliente = 1112587741;
		this.idCarro = 1L;
		this.fechaRecogida = LocalDateTime.of(2020, 9, 10, 9, 0);
	}
	
	public ReservaTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public ReservaTestDataBuilder conIdCliente(long idCliente) {
		this.idCliente = idCliente;
		return this;
	}
	
	public ReservaTestDataBuilder conIdCarro(long idCarro) {
		this.idCarro = idCarro;
		return this;
	}
	
	public ReservaTestDataBuilder conFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
		return this;
	}
	
	public Reserva build() {
		return new Reserva(id, idCliente, idCarro, fechaRecogida);
	}

}
