package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVAS")
public class ReservaEntidad {
		
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@Column(name = "ID_CLIENTE")
	private long idCliente;
	
	@Column(name = "ID_CARRO")
	private long idCarro;
	
	@Column(name = "FECHA_RECOGIDA")
	private LocalDateTime fechaRecogida;

	public ReservaEntidad() {}
	
	public ReservaEntidad(long id, long idCliente, long idCarro, LocalDateTime fechaRecogida) {
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
