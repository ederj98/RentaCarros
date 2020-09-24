package com.ceiba.adn.carclick.dominio.modelo;

import java.time.LocalDateTime;

import com.ceiba.adn.carclick.dominio.servicio.ValidarCampos;
import com.ceiba.adn.carclick.dominio.servicio.ValidarFechas;

public class Reserva {
	
	private static final String LA_FECHA_DE_RECOGIDA__DEL_VEHICULO_ES_REQUERIDO = "La fecha de recogida del vehiculo es requerido";
	private static final String EL_ID_DEL_CLIETE_ES_REQUERIDO = "El id del cliente es requerido";
	private static final String EL_ID_DEL_VEHICULO_ES_REQUERIDO = "El id del vehiculo es requerido";
	
	private long id;
	private long idCliente;
	private long idCarro;
	private LocalDateTime fechaRecogida;
	
	public Reserva(long id, long idCliente, long idCarro, LocalDateTime fechaRecogida) {
		ValidarCampos.esVacio(fechaRecogida, LA_FECHA_DE_RECOGIDA__DEL_VEHICULO_ES_REQUERIDO);
		ValidarFechas.validarFechaFueraHorarioServicio(fechaRecogida);
		ValidarCampos.esVacio(idCliente, EL_ID_DEL_CLIETE_ES_REQUERIDO);
		ValidarCampos.esVacio(idCarro, EL_ID_DEL_VEHICULO_ES_REQUERIDO);
		
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
