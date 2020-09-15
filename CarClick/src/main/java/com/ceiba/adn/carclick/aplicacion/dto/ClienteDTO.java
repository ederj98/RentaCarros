package com.ceiba.adn.carclick.aplicacion.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO {

	private long idCliente;
	private String nombreCompleto;
	private String telefono;
	private String direccion;
	private String email;
	
	@JsonCreator
	public ClienteDTO(@JsonProperty("idCliente") long idCliente, @JsonProperty("nombreCompleto") String nombreCompleto, 
			@JsonProperty("telefono") String telefono, @JsonProperty("direccion") String direccion, @JsonProperty("email") String email) {
		this.idCliente = idCliente;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getEmail() {
		return email;
	}
	
	
}
