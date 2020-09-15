package com.ceiba.adn.carclick.aplicacion.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservaDTO {

	private long id;
	private long idCliente;
	private long idCarro;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaRecogida;
	
	@JsonCreator
	public ReservaDTO(@JsonProperty("id") long id, @JsonProperty("idCliente") long idCliente, 
			@JsonProperty("idCarro") long idCarro, @JsonProperty("fechaRecogida") LocalDateTime fechaRecogida) {
		this.id = id;
		this.idCliente = idCliente;
		this.idCarro = idCarro;
		this.fechaRecogida = fechaRecogida;
	}

	public long getId() {
		return id;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public long getIdCarro() {
		return idCarro;
	}

	public LocalDateTime getFechaRecogida() {
		return fechaRecogida;
	}
}
