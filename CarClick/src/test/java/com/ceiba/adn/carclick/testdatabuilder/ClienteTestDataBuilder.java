package com.ceiba.adn.carclick.testdatabuilder;

import com.ceiba.adn.carclick.dominio.modelo.Cliente;

public class ClienteTestDataBuilder {

	public long idCliente;
	public String nombreCompleto;
	public String telefono;
	public String direccion;
	public String email;
	
	public ClienteTestDataBuilder(long idCliente, String nombreCompleto, String telefono, String direccion,
			String email) {
		this.idCliente = idCliente;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}

	public ClienteTestDataBuilder() {
		this.idCliente = 1112587741;
		this.nombreCompleto = "John Doe";
		this.telefono = "3215897412";
		this.direccion = "Carrera 90";
		this.email = "jd@gmail.com";
	}
	
	public Cliente build() {
		return new Cliente(idCliente, nombreCompleto, telefono, direccion, email);
	}
	
	public ClienteTestDataBuilder conIdCliente(long idCliente) {
		this.idCliente = idCliente;
		return this;
	}
	
	public ClienteTestDataBuilder conNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}

	public ClienteTestDataBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}
	
	public ClienteTestDataBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}
	
	public ClienteTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}
}
