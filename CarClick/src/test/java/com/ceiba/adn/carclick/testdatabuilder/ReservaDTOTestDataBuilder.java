package com.ceiba.adn.carclick.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.adn.carclick.aplicacion.dto.ReservaDTO;

public class ReservaDTOTestDataBuilder {

	public long id;
	public long idCliente;
	public long idCarro;
	public LocalDateTime fechaRecogida;
		
	public ReservaDTOTestDataBuilder(long id, long idCliente, long idCarro, LocalDateTime fechaRecogida) {
		this.id = id;
		this.idCliente = idCliente;
		this.idCarro = idCarro;
		this.fechaRecogida = fechaRecogida;
	}

	public ReservaDTOTestDataBuilder() {
		this.id = 1L;
		this.idCliente = 1112587741;
		this.idCarro = 1L;
		this.fechaRecogida = LocalDateTime.of(2020, 9, 10, 9, 0);
	}
	
	public ReservaDTOTestDataBuilder conId(long id) {
		this.id = id;
		return this;
	}
	
	public ReservaDTOTestDataBuilder conIdCliente(long idCliente) {
		this.idCliente = idCliente;
		return this;
	}
	
	public ReservaDTOTestDataBuilder conIdCarro(long idCarro) {
		this.idCarro = idCarro;
		return this;
	}
	
	public ReservaDTOTestDataBuilder conFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
		return this;
	}
	
	public ReservaDTO build() {
		return new ReservaDTO(id, idCliente, idCarro, fechaRecogida);
	}
}
