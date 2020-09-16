package com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class ReservaEntidad {
		
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private ClienteEntidad idCliente;
	
	@ManyToOne
	@JoinColumn(name = "ID_CARRO")
	private CarroEntidad idCarro;
	
	@Column(name = "FECHA_RECOGIDA")
	private LocalDateTime fechaRecogida;
	
	@OneToOne(mappedBy = "reserva")
	private DetalleReservaEntidad detalleReserva;

	public ReservaEntidad() {}
	
	public ReservaEntidad(long id, ClienteEntidad idCliente, CarroEntidad idCarro, LocalDateTime fechaRecogida) {
		this.id = id;
		this.idCliente = idCliente;
		this.idCarro = idCarro;
		this.fechaRecogida = fechaRecogida;
	}

	public long getId() {
		return id;
	}

	public ClienteEntidad getIdCliente() {
		return idCliente;
	}

	public CarroEntidad getIdCarro() {
		return idCarro;
	}

	public LocalDateTime getFechaRecogida() {
		return fechaRecogida;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setIdCarro(CarroEntidad idCarro) {
		this.idCarro = idCarro;
	}

	public void setFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}

	public void setDetalleReserva(DetalleReservaEntidad detalleReserva) {
		this.detalleReserva = detalleReserva;
	}
}
