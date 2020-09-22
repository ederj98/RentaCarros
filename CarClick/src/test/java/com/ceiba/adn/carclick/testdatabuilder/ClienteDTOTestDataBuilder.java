package com.ceiba.adn.carclick.testdatabuilder;

import com.ceiba.adn.carclick.aplicacion.dto.ClienteDTO;

public class ClienteDTOTestDataBuilder {

	public long idCliente;
	public String nombreCompleto;
	public String telefono;
	public String direccion;
	public String email;
	
	public ClienteDTOTestDataBuilder(long idCliente, String nombreCompleto, String telefono, String direccion,
			String email) {
		this.idCliente = idCliente;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}
	
	public ClienteDTOTestDataBuilder() {
		this.idCliente = 1112587741;
		this.nombreCompleto = "John Doe";
		this.telefono = "3215897412";
		this.direccion = "Carrera 90";
		this.email = "jd@gmail.com";
	}
	
	public ClienteDTO build() {
		return new ClienteDTO(idCliente, nombreCompleto, telefono, direccion, email);
	}
	
	public ClienteDTOTestDataBuilder conIdCliente(long idCliente) {
		this.idCliente = idCliente;
		return this;
	}
	
	public ClienteDTOTestDataBuilder conNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}

	public ClienteDTOTestDataBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}
	
	public ClienteDTOTestDataBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}
	
	public ClienteDTOTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
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
