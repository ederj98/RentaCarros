package com.ceiba.adn.carclick.testdatabuilder;

import com.ceiba.adn.carclick.infraestructura.adaptador.repositorio.entidad.ClienteEntidad;

public class ClienteEntidadTestDataBuilder {

	public long idCliente;
	public String nombreCompleto;
	public String telefono;
	public String direccion;
	public String email;
	
	public ClienteEntidadTestDataBuilder(long idCliente, String nombreCompleto, String telefono, String direccion,
			String email) {
		this.idCliente = idCliente;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}
	
	public ClienteEntidadTestDataBuilder() {
		this.idCliente = 1112587741;
		this.nombreCompleto = "John Doe";
		this.telefono = "3215897412";
		this.direccion = "Carrera 90";
		this.email = "jd@gmail.com";
	}
	
	public ClienteEntidad build() {
		return new ClienteEntidad(idCliente, nombreCompleto, telefono, direccion, email);
	}
	
	public ClienteEntidadTestDataBuilder conIdCliente(long idCliente) {
		this.idCliente = idCliente;
		return this;
	}
	
	public ClienteEntidadTestDataBuilder conNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}

	public ClienteEntidadTestDataBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}
	
	public ClienteEntidadTestDataBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}
	
	public ClienteEntidadTestDataBuilder conEmail(String email) {
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
