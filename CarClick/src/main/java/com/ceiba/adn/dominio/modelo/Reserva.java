package com.ceiba.adn.dominio.modelo;

import java.time.LocalDateTime;

public class Reserva {
	
	private long id;
	private long idCliente;
	private long idCarro;
	private LocalDateTime fechaRecogida;
	
	public Reserva(long id, long idCliente, long idCarro, LocalDateTime fechaRecogida) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idCarro = idCarro;
		this.fechaRecogida = fechaRecogida;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(long idCarro) {
		this.idCarro = idCarro;
	}

	public LocalDateTime getFechaRecogida() {
		return fechaRecogida;
	}

	public void setFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}
}
