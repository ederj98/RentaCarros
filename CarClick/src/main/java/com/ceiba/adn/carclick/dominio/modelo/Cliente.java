package com.ceiba.adn.carclick.dominio.modelo;

import com.ceiba.adn.carclick.dominio.servicio.ValidarCampos;

public class Cliente {
	
	private long idCliente;
	private String nombreCompleto;
	private String telefono;
	private String direccion;
	private String email;
	
	private static final String EL_ID_DEL_CLIENTE_ES_REQUERIDO = "El id del cliente es requerido";
	private static final String EL_NOMBRE_DEL_CLIENTE_ES_REQUERIDO = "El nombre del cliente es requerido";
	private static final String EL_TELEFONO_DEL_CLIENTE_ES_REQUERIDO = "El telefono del cliente es requerido";
		
	public Cliente(long idCliente, String nombreCompleto, String telefono, String direccion, String email) {
		ValidarCampos.esVacio(idCliente, EL_ID_DEL_CLIENTE_ES_REQUERIDO);
		ValidarCampos.esVacio(nombreCompleto, EL_NOMBRE_DEL_CLIENTE_ES_REQUERIDO);
		ValidarCampos.esVacio(telefono, EL_TELEFONO_DEL_CLIENTE_ES_REQUERIDO);
		
		this.idCliente = idCliente;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
